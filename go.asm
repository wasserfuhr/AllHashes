;; http://peter.michaux.ca/articles/assembly-hello-world-for-os-x
section .text
global go;make the main function externally visible
go:

;;prepare the arguments for the system call to write
 push dword mylen; message length
 push dword mymsg; message to write
 push dword 1	; file descriptor value

;;make the system call to write
 mov eax, 0x4; system call number for write
 sub esp, 4	; OS X (and BSD) system calls needs "extra space" on stack
 int 0x80	; make the actual system call

;;clean up the stack
 add esp, 16	; 3 args * 4 bytes/arg + 4 bytes extra space = 16 bytes

;;exit the program
;;prepare the argument for the sys call to exit
 push dword 0	; exit status returned to the operating system

;;make the call to sys call to exit
 mov eax, 0x1	; system call number for exit
 sub esp, 4	; OS X (and BSD) system calls needs "extra space" on stack
 int 0x80	; make the system call
;;no need to clean up the stack because no code here would executed: already exited

section .data
 mymsg db "HelloWorld",0xa ;string with a carriage-return
 mylen equ $-mymsg	    ;string length in bytes
