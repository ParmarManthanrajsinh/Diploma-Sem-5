LXI B, 9009H   ; BC = 9009H  (B=90H, C=09H)
LXI H, 1003H   ; HL = 1003H
SPHL           ; SP = 1003H
PUSH B         ; put BC onto the stack
HLT
