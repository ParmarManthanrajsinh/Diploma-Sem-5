LXI H, 9009H   ; HL = 9009H
SHLD 1001H     ; store HL → memory[1001H] = 09H, memory[1002H] = 90H

LXI H, 1001H   ; HL = 1001H
SPHL           ; SP = 1001H
POP B          ; take 2 bytes from stack → into BC

HLT
