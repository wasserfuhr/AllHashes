#include <stdio.h>



#include <stdint.h>
#include <time.h>
#include <openssl/sha.h>

// http://nayuki.eigenstate.org/res/fast-sha1-hash-implementation-in-x86-assembly/sha1-fast.c

//0000014586234b1d5296ab0051eb9c86767092ae b6be

unsigned char mhash[SHA_DIGEST_LENGTH];
 
int main(void){
  unsigned char data[] = "a2!!";

  memset(mhash, 0xff, SHA_DIGEST_LENGTH*2);
  unsigned char j=0;
  do {
   fprintf(stdout,"...%d\n",j);
   fflush(stdout);
   unsigned char i=0;
   do {
    data[2]=i;
    data[3]=j;
    fastIter(data);
    i++;
   } while (i!=0);
   j++;
  } while(j!=0);
  //printf("%ld",clock());
}

int fastIter(unsigned char data[]){
  size_t length = sizeof(data);
  unsigned char hash[SHA_DIGEST_LENGTH];
  char buf[SHA_DIGEST_LENGTH*2];

  memset(buf, 0x0, SHA_DIGEST_LENGTH*2);

  unsigned char k=0;
  do {
   data[0]=k;
   unsigned char l=0;
   do {
    data[1]=l;
    SHA1((const unsigned char *)data, length, hash);

    char n=0;
    short j=0;
    do{
     if (hash[j]>mhash[j]) break;
     if (hash[j]<mhash[j]) {
      for (short c=0; c<SHA_DIGEST_LENGTH; c++) {
        mhash[c]=hash[c];
      }
      for (int i=0; i < SHA_DIGEST_LENGTH; i++) {
       sprintf((char*)&(buf[i*2]), "%02x", mhash[i]);
      }
      fprintf(stdout,"%s %2x%2x%2x%2x\n", buf,k,l,data[2],data[3]);
      fflush(stdout);
      break;
     }
     j++;
    } while(j < SHA_DIGEST_LENGTH);
    l++;
   } while(l!=0);
   k++;
  } while (k!=0);
}
