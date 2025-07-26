# 8085 Instruction Set

| Serial No. | Instruction | Format                          | Addressing Mode | Size  | Type           | Example        |
|-----------:|:-----------:|:--------------------------------|:---------------:|:-----:|:---------------|:---------------|
| 1          | MOV A, B    | 1 byte, register, register     | Register        | 1 byte| Data Transfer  | MOV A, B       |
| 2          | MVI A, 3Ch  | 2 bytes, register, immediate   | Immediate       | 2 bytes| Data Transfer | MVI A, 3Ch     |
| 3          | LDA 2000H   | 3 bytes, memory address        | Direct          | 3 bytes| Data Transfer | LDA 2000H      |
| 4          | STA 2050H   | 3 bytes, memory address        | Direct          | 3 bytes| Data Transfer | STA 2050H      |
| 5          | LHLD 3000H  | 3 bytes, memory address        | Direct          | 3 bytes| Data Transfer | LHLD 3000H     |
| 6          | ADD B       | 1 byte, register               | Register        | 1 byte| Arithmetic     | ADD B          |
| 7          | ADI 05H     | 2 bytes, immediate data        | Immediate       | 2 bytes| Arithmetic    | ADI 05H        |
| 8          | INR C       | 1 byte, register               | Register        | 1 byte| Arithmetic     | INR C          |
| 9          | DCR D       | 1 byte, register               | Register        | 1 byte| Arithmetic     | DCR D          |
| 10         | CMP E       | 1 byte, register               | Register        | 1 byte| Arithmetic     | CMP E          |
| 11         | ANA A       | 1 byte, register               | Register        | 1 byte| Logical        | ANA A          |
| 12         | CMA         | 1 byte, implicit               | Implicit        | 1 byte| Logical        | CMA            |
| 13         | RLC         | 1 byte, implicit               | Implicit        | 1 byte| Rotate         | RLC            |
| 14         | JZ 1000H    | 3 bytes, memory address        | Direct          | 3 bytes| Branch        | JZ 1000H       |
| 15         | JMP 1500H   | 3 bytes, memory address        | Direct          | 3 bytes| Branch        | JMP 1500H      |
| 16         | CALL 2000H  | 3 bytes, memory address        | Direct          | 3 bytes| Call/Subroutine| CALL 2000H     |
| 17         | RET         | 1 byte, implicit               | Implicit        | 1 byte| Call/Subroutine| RET            |
| 18         | EI          | 1 byte, implicit               | Implicit        | 1 byte| Control        | EI             |
| 19         | DI          | 1 byte, implicit               | Implicit        | 1 byte| Control        | DI             |
| 20         | HLT         | 1 byte, implicit               | Implicit        | 1 byte| Control        | HLT            |
