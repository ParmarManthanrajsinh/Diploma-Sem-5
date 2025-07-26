# 8085 Instruction Set

| No | Instr       | Fmt          | Addr Mode | Size | Type         | Example      |
|---:|:------------|:-------------|:----------|:----:|:-------------|:-------------|
| 1  | MOV A,B     | 1 B, r1,r2   | Reg       | 1b   | Data Xfer    | MOV A,B      |
| 2  | MVI A,3Ch   | 2 B, r,data  | Imm       | 2b   | Data Xfer    | MVI A,3Ch    |
| 3  | LDA 2000H   | 3 B, addr    | Direct    | 3b   | Data Xfer    | LDA 2000H    |
| 4  | STA 2050H   | 3 B, addr    | Direct    | 3b   | Data Xfer    | STA 2050H    |
| 5  | LHLD 3000H  | 3 B, addr    | Direct    | 3b   | Data Xfer    | LHLD 3000H   |
| 6  | ADD B       | 1 B, r       | Reg       | 1b   | Arithmetic   | ADD B        |
| 7  | ADI 05H     | 2 B, data    | Imm       | 2b   | Arithmetic   | ADI 05H      |
| 8  | INR C       | 1 B, r       | Reg       | 1b   | Arithmetic   | INR C        |
| 9  | DCR D       | 1 B, r       | Reg       | 1b   | Arithmetic   | DCR D        |
| 10 | CMP E       | 1 B, r       | Reg       | 1b   | Arithmetic   | CMP E        |
| 11 | ANA A       | 1 B, r       | Reg       | 1b   | Logical      | ANA A        |
| 12 | CMA         | 1 B, —       | Implicit  | 1b   | Logical      | CMA          |
| 13 | RLC         | 1 B, —       | Implicit  | 1b   | Rotate       | RLC          |
| 14 | JZ 1000H    | 3 B, addr    | Direct    | 3b   | Branch       | JZ 1000H     |
| 15 | JMP 1500H   | 3 B, addr    | Direct    | 3b   | Branch       | JMP 1500H    |
| 16 | CALL 2000H  | 3 B, addr    | Direct    | 3b   | Call/Subrt   | CALL 2000H   |
| 17 | RET         | 1 B, —       | Implicit  | 1b   | Call/Subrt   | RET          |
| 18 | EI          | 1 B, —       | Implicit  | 1b   | Control      | EI           |
| 19 | DI          | 1 B, —       | Implicit  | 1b   | Control      | DI           |
| 20 | HLT         | 1 B, —       | Implicit  | 1b   | Control      | HLT          |
