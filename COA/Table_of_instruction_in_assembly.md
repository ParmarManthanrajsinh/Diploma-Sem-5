# 8085 Instruction Examples (Detailed)

| No | Description                         | Fmt           | Addr | Size | Cat           | Ex           |
|---:|:------------------------------------|:-------------:|:----:|:----:|:--------------|:-------------|
| 1  | Move register to register           | 1B, r1, r2    | reg  | 1B   | Data Xfer     | MOV A, B     |
| 2  | Move immediate to register          | 2B, r, imm    | imm  | 2B   | Data Xfer     | MVI B, 0AH   |
| 3  | Load accumulator from memory        | 3B, addr      | dir  | 3B   | Data Xfer     | LDA 2500H    |
| 4  | Store accumulator to memory         | 3B, addr      | dir  | 3B   | Data Xfer     | STA 2500H    |
| 5  | Load H/L pair from memory           | 3B, addr      | dir  | 3B   | Data Xfer     | LHLD 3000H   |
| 6  | Exchange H and L registers          | 1B, —         | imp  | 1B   | Data Xfer     | XCHG         |
| 7  | Load 16‑bit immediate to reg‑pair   | 3B, rp, imm16 | imm  | 3B   | Data Xfer     | LXI H,4000H  |
| 8  | Add register to accumulator         | 1B, r         | reg  | 1B   | Arithmetic    | ADD C        |
| 9  | Add immediate data to accumulator   | 2B, imm       | imm  | 2B   | Arithmetic    | ADI 07H      |
| 10 | Subtract register from accumulator  | 1B, r         | reg  | 1B   | Arithmetic    | SUB D        |
| 11 | Increment register                  | 1B, r         | reg  | 1B   | Arithmetic    | INR E        |
| 12 | Decrement register                  | 1B, r         | reg  | 1B   | Arithmetic    | DCR B        |
| 13 | Add H/L pair to HL register pair    | 1B, rp        | imp  | 1B   | Arithmetic    | DAD B        |
| 14 | Logical AND register with A         | 1B, r         | reg  | 1B   | Logical       | ANA A        |
| 15 | Logical OR register with A          | 1B, r         | reg  | 1B   | Logical       | ORA C        |
| 16 | Logical XOR register with A         | 1B, r         | reg  | 1B   | Logical       | XRA D        |
| 17 | Complement accumulator              | 1B, —         | imp  | 1B   | Logical       | CMA          |
| 18 | Compare register with accumulator   | 1B, r         | reg  | 1B   | Logical       | CMP E        |
| 19 | Unconditional jump                  | 3B, addr      | dir  | 3B   | Branch        | JMP 1500H    |
| 20 | Jump if zero flag set               | 3B, addr      | dir  | 3B   | Branch        | JZ 1100H     |
| 21 | Call subroutine                     | 3B, addr      | dir  | 3B   | Branch        | CALL 2000H   |
| 22 | Return from subroutine              | 1B, —         | imp  | 1B   | Branch        | RET          |
| 23 | Push register pair onto stack       | 1B, rp        | imp  | 1B   | Stack         | PUSH H       |
| 24 | Pop register pair from stack        | 1B, rp        | imp  | 1B   | Stack         | POP D        |
| 25 | Load SP with H/L pair               | 1B, —         | imp  | 1B   | Stack         | SPHL         |
| 26 | Read from I/O port                  | 2B, port      | imm  | 2B   | I/O           | IN 05H       |
| 27 | Write to I/O port                   | 2B, port      | imm  | 2B   | I/O           | OUT 06H      |
| 28 | Enable interrupts                   | 1B, —         | imp  | 1B   | Machine Ctrl  | EI           |
| 29 | Disable interrupts                  | 1B, —         | imp  | 1B   | Machine Ctrl  | DI           |
| 30 | Halt processor                      | 1B, —         | imp  | 1B   | Machine Ctrl  | HLT          |
