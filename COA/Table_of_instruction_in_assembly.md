# 8085 Instruction Set Reference

| Serial No. | Instruction | Format               | Addressing Mode | Size (Bytes) | Type (By Task) | Example                                  |
|-----------:|:-----------:|:--------------------:|:---------------:|:------------:|:--------------:|:-----------------------------------------|
| 1          |   `MOV A,B` | `1 Byte, r1, r2`     | Register        | 1            | Data Transfer  | `MOV A,B` ; Copy contents of B into A    |
| 2          |  `MVI A,3Ch`| `2 Bytes, r, data`   | Immediate       | 2            | Data Transfer  | `MVI A,3Ch` ; Load immediate 0x3C into A |
| 3          |  `LDA 2000H`| `3 Bytes, addr`      | Direct          | 3            | Data Transfer  | `LDA 2000H` ; Load A from memory[2000H]  |
| 4          |  `STA 2050H`| `3 Bytes, addr`      | Direct          | 3            | Data Transfer  | `STA 2050H` ; Store A into memory[2050H] |
| 5          | `LHLD 3000H`| `3 Bytes, addr`      | Direct          | 3            | Data Transfer  | `LHLD 3000H` ; Load L←[3000H], H←[3001H] |
| 6          |   `ADD B`   | `1 Byte, r`          | Register        | 1            | Arithmetic     | `ADD B` ; A ← A + B                      |
| 7          |  `ADI 05H`  | `2 Bytes, data`      | Immediate       | 2            | Arithmetic     | `ADI 05H` ; A ← A + 0x05                 |
| 8          |   `INR C`   | `1 Byte, r`          | Register        | 1            | Arithmetic     | `INR C` ; C ← C + 1                      |
| 9          |   `DCR D`   | `1 Byte, r`          | Register        | 1            | Arithmetic     | `DCR D` ; D ← D − 1                      |
| 10         |   `CMP E`   | `1 Byte, r`          | Register        | 1            | Arithmetic     | `CMP E` ; Compare A with E               |
| 11         |   `ANA A`   | `1 Byte, r`          | Register        | 1            | Logical        | `ANA A` ; A ← A ∧ A                      |
| 12         |    `CMA`    | `1 Byte, —`          | Implicit        | 1            | Logical        | `CMA` ; A ← 1’s complement of A          |
| 13         |    `RLC`    | `1 Byte, —`          | Implicit        | 1            | Rotate         | `RLC` ; Rotate A left through Carry      |
| 14         | `JZ 1000H`  | `3 Bytes, addr`      | Direct          | 3            | Branch         | `JZ 1000H` ; Jump if Zero flag set       |
| 15         | `JMP 1500H` | `3 Bytes, addr`      | Direct          | 3            | Branch         | `JMP 1500H` ; Unconditional jump         |
| 16         |`CALL 2000H` | `3 Bytes, addr`      | Direct          | 3            | Call/Subrtn    | `CALL 2000H` ; Call subroutine at 2000H  |
| 17         |    `RET`    | `1 Byte, —`          | Implicit        | 1            | Call/Subrtn    | `RET` ; Return from subroutine           |
| 18         |     `EI`    | `1 Byte, —`          | Implicit        | 1            | Control        | `EI` ; Enable interrupts                 |
| 19         |     `DI`    | `1 Byte, —`          | Implicit        | 1            | Control        | `DI` ; Disable interrupts                |
| 20         |    `HLT`    | `1 Byte, —`          | Implicit        | 1            | Control        | `HLT` ; Halt processor                   |
