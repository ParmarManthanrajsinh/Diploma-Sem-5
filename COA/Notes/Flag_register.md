# 8085 — Flag Register (Exam Cheat‑Sheet)
---

## Bit layout (MSB → LSB)
```
7 6 5 4 3 2 1 0
S Z - AC - P 1 CY
```

- Bits 5 and 3 are unused/reserved. Bit 1 is always 1 in status representation.

---

## Flags — definitions, when set, short example

- **S — Sign flag (bit 7)**
  - **Meaning:** Set if the result is negative (MSB of 8‑bit result = 1).
  - **When set:** Result’s bit7 = 1.
  - **Example:** `MVI A, 80H` → S = 1.

- **Z — Zero flag (bit 6)**
  - **Meaning:** Set if result = 0.
  - **When set:** All bits of result = 0.
  - **Example:** `MVI A, 02H
SUB A` → Z = 1.

- **AC — Auxiliary Carry (bit 4)**
  - **Meaning:** Carry from bit 3 to bit 4 (used for BCD/DAA adjustments).
  - **When set:** Low nibble addition/subtraction generated a carry into bit 4.
  - **Example:** `MVI A, 0FH
ADI 01H` → AC = 1 (and CY may or may not be set).

- **P — Parity flag (bit 2)**
  - **Meaning:** Set if result has even number of 1‑bits (even parity).
  - **When set:** Parity(result) = even.
  - **Example:** `MVI A, 03H` (0b00000011 → two 1s) → P = 1.

- **CY — Carry flag (bit 0)**
  - **Meaning:** Set if there is a carry out (addition) or borrow (subtraction) from the MSB.
  - **When set:** Arithmetic produced carry/borrow beyond bit 7.
  - **Example:** `MVI A, FFH
ADI 01H` → CY = 1.

---

## Which instructions affect which flags (quick rules)

- **Most arithmetic (ADD, SUB, ADC, SBB):** affect **S, Z, AC, P, CY**.
- **INR/DCR (increment/decrement):** affect **S, Z, AC, P** **but NOT CY**.
- **Logical ops (ANA, ORA, XRA):** set **S, Z, P**; **CY = 0** after logical ops. AC behavior varies—treat AC as cleared for most logical ops unless specified.
- **CMP (compare):** updates flags as if A - operand were performed (affects S, Z, P, CY) — A is not changed.
- **DAA (decimal adjust):** uses **AC** and **CY** for BCD correction.

---

## Exam‑ready quick facts (memorize)

- Flags of interest: **S (sign), Z (zero), AC (auxiliary), P (parity), CY (carry)**.
- **INR does not change CY.**
- **Logical instructions clear CY (CY = 0).**
- **AC is for BCD/DAA only** — rarely used in simple integer logic.
- On a subtraction, **CY = 1** indicates a borrow.

---

## Short mnemonic

**S Z _ A _ P _ C**  → read as **Sign, Zero, (skip), Aux, (skip), Parity, (one), Carry** — helps to recall positions.

---
