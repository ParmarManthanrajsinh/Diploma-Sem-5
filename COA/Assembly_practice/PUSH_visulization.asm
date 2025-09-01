; Visualization of PUSH instruction

LXI B, 9009H     ; Load BC register pair with 9009H
                 ; Now B = 90H, C = 09H

LXI H, 1003H     ; Load HL with 1003H
                 ; So H = 10H, L = 03H

SPHL             ; Copy HL into Stack Pointer
                 ; So SP = 1003H

PUSH B           ; Push contents of BC register pair onto stack
                 ; Step 1: SP ← SP - 1 = 1002H
                 ;         (SP) ← B = 90H → memory[1002H] = 90H
                 ; Step 2: SP ← SP - 1 = 1001H
                 ;         (SP) ← C = 09H → memory[1001H] = 09H
                 ; So after PUSH:
                 ; memory[1001H] = 09H
                 ; memory[1002H] = 90H
                 ; SP = 1001H

HLT             
