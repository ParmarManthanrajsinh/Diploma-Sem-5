; Visualization of POP instruction

LXI H, 9009H     ; Load HL register pair with 9009H
                 ; Now H = 90H, L = 09H

SHLD 1001H       ; Store HL into memory at 1001H
                 ; → 1001H = 09H (L), 1002H = 90H (H)

LXI H, 1001H     ; Load HL with 1001H
                 ; Now H = 10H, L = 01H

SPHL             ; Copy HL into Stack Pointer
                 ; So SP = 1001H

POP B            ; Pop two bytes from stack into BC pair
                 ; Step 1: C ← (SP) = (1001H) = 09H
                 ; Step 2: B ← (SP+1) = (1002H) = 90H
                 ; Step 3: SP ← SP + 2 = 1003H
                 ; So finally: B = 90H, C = 09H → BC = 9009H

HLT             
