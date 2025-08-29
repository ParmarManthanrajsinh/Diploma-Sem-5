# 8085 Registers — Structure, Definitions & Short Examples

A focused reference listing **only the registers**, their **structure (size & role)**, a one‑line **definition**, and a **very short example** for each.

---

### A — Accumulator

- **Size:** 8-bit
- **Definition:** Central register used by almost all arithmetic and logical instructions.
- **Example:**

```asm
MVI A, 05H  ; A = 0x05
ADD B       ; A = A + B
```

---

### B, C, D, E, H, L — General-purpose registers

- **Size:** 8-bit each
- **Definition:** Temporary storage for data; used individually or paired for 16-bit operations.
- **Example (8-bit):**

```asm
MOV A, B    ; A <- B
```

---

### BC, DE, HL — Register pairs (16-bit)

- **Size:** 16-bit (formed by pairing B+C, D+E, H+L)
- **Definition:** Used for 16-bit addresses, arithmetic, and stack/data transfers. **HL** is commonly used as a memory pointer.
- **Example (HL as pointer):**

```asm
LXI H, 2050H ; HL = 0x2050
MOV A, M     ; A <- (HL)
```

---

### F — Flag register

- **Size:** 8-bit
- **Definition:** Holds status flags set/cleared by operations.
- **Bits (MSB→LSB):** S Z - AC - P 1 CY
- **Example:**

```asm
ADD C        ; affects Z (zero), S (sign), P (parity), CY (carry) etc.
```

---

### PC — Program Counter

- **Size:** 16-bit
- **Definition:** Contains address of the next instruction to fetch.
- **Example (affects PC):**

```asm
JMP 2000H    ; PC <- 0x2000 (next instruction fetched from 2000H)
```

---

### SP — Stack Pointer

- **Size:** 16-bit
- **Definition:** Points to the top of the stack in memory (stack grows downward).
- **Example:**

```asm
PUSH B       ; SP = SP - 2; BC pushed onto stack
POP D        ; DE <- popped value; SP = SP + 2
```

---

*End of concise register-structure reference.*

