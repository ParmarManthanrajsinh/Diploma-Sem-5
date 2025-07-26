# 8085 Instruction Examples (by Syllabus)

| No. | Instr             | Format               | Addr Mode   | Size     | Category                   | Example      |
|----:|:------------------|:---------------------|:------------|:---------|:---------------------------|:-------------|
| 1   | Move Reg→Reg      | 1 byte, r1, r2       | Register    | 1 byte   | Data Transfer              | MOV A, B     |
| 2   | Load Immediate    | 2 bytes, r, data     | Immediate   | 2 bytes  | Data Transfer              | MVI B, 0Ah   |
| 3   | Load from Memory  | 3 bytes, addr        | Direct      | 3 bytes  | Data Transfer              | LDA 2500H    |
| 4   | Store to Memory   | 3 bytes, addr        | Direct      | 3 bytes  | Data Transfer              | STA 2500H    |
| 5   | Load H/L Pair     | 3 bytes, addr        | Direct      | 3 bytes  | Data Transfer              | LHLD 3000H   |
| 6   | Exchange Regs     | 1 byte               | Implicit    | 1 byte   | Data Transfer              | XCHG         |
| 7   | Load Immediate 16 | 3 bytes, rp, data16  | Immediate   | 3 bytes  | Data Transfer              | LXI H, 4000H |
| 8   | Add Register      | 1 byte, r            | Register    | 1 byte   | Arithmetic                 | ADD C        |
| 9   | Add Immediate      | 2 bytes, data       | Immediate   | 2 bytes  | Arithmetic                 | ADI 07H      |
| 10  | Subtract Register | 1 byte, r            | Register    | 1 byte   | Arithmetic                 | SUB D        |
| 11  | Increment Reg     | 1 byte, r            | Register    | 1 byte   | Arithmetic                 | INR E        |
| 12  | Decrement Reg     | 1 byte, r            | Register    | 1 byte   | Arithmetic                 | DCR B        |
| 13  | Add H/L Pair      | 1 byte               | Implicit    | 1 byte   | Arithmetic                 | DAD B        |
| 14  | Logical AND       | 1 byte, r            | Register    | 1 byte   | Logical                     | ANA A        |
| 15  | Logical OR        | 1 byte, r            | Register    | 1 byte   | Logical                     | ORA C        |
| 16  | Logical XOR       | 1 byte, r            | Register    | 1 byte   | Logical                     | XRA D        |
| 17  | Complement Acc    | 1 byte               | Implicit    | 1 byte   | Logical                     | CMA          |
| 18  | Compare           | 1 byte, r            | Register    | 1 byte   | Logical                     | CMP E        |
| 19  | Jump Uncond.      | 3 bytes, addr        | Direct      | 3 bytes  | Branch & Looping            | JMP 1500H    |
| 20  | Jump If Zero      | 3 bytes, addr        | Direct      | 3 bytes  | Branch & Looping            | JZ 1100H     |
| 21  | Call Subroutine   | 3 bytes, addr        | Direct      | 3 bytes  | Branch & Looping            | CALL 2000H   |
| 22  | Return            | 1 byte               | Implicit    | 1 byte   | Branch & Looping            | RET          |
| 23  | Push Reg Pair     | 1 byte, rp           | Implicit    | 1 byte   | Stack Instructions          | PUSH H       |
| 24  | Pop Reg Pair      | 1 byte, rp           | Implicit    | 1 byte   | Stack Instructions          | POP D        |
| 25  | Set SP = H/L      | 1 byte               | Implicit    | 1 byte   | Stack Instructions          | SPHL         |
| 26  | Input from Port   | 2 bytes, port#       | Immediate   | 2 bytes  | I/O Instructions            | IN 05H       |
| 27  | Output to Port    | 2 bytes, port#       | Immediate   | 2 bytes  | I/O Instructions            | OUT 06H      |
| 28  | Enable Interrupts | 1 byte               | Implicit    | 1 byte   | Machine Control Instructions | EI           |
| 29  | Disable Interrupts| 1 byte               | Implicit    | 1 byte   | Machine Control Instructions | DI           |
| 30  | Halt Processor    | 1 byte               | Implicit    | 1 byte   | Machine Control Instructions | HLT          |
