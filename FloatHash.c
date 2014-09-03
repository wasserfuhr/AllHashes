#include <stdio.h>
#include <stdint.h>
#include <time.h>
#include <openssl/sha.h>

//compile: cc -std=c99 -lcrypto FloatHash.c
// results: https://code.google.com/p/ungit/wiki/BfHash
//to TerraDrive: e.g. echo -en "\x03\xa1\x54\xa9" |sha1sum

//SeeAlso http://nayuki.eigenstate.org/res/fast-sha1-hash-implementation-in-x86-assembly/sha1-fast.c

unsigned char mhash[SHA_DIGEST_LENGTH];

int main(void) {
  unsigned char data[] = "12345";

  memset(mhash, 0xff, SHA_DIGEST_LENGTH*2);
  unsigned char k=0;
  do {
   unsigned char j=0;
   do {
    fprintf(stdout,"%-40s ______%02x%02x\n", "", j, k);
    fflush(stdout);
    unsigned char i=0;
    do {
     data[2]=i;
     data[3]=j;
     data[4]=k;
     fastIter(data);
     i++;
    } while (i!=0);
    j++;
   } while (j!=0);
   k++;
  } while(k!=0);
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
      fprintf(stdout,"%s %02x%02x%02x%02x%02x\n", buf, k,l,data[2],data[3],data[4]);
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
