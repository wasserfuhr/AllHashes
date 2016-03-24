#include <stdio.h>
#include <stdint.h>
#include <time.h>
#include <openssl/sha.h>

//compile: cc -std=c99 -lcrypto BfHash.c
// results: https://code.google.com/p/ungit/wiki/BfHash
//to TerraDrive: e.g. echo -en "\x03\xa1\x54\xa9" |sha1sum

//SeeAlso http://nayuki.eigenstate.org/res/fast-sha1-hash-implementation-in-x86-assembly/sha1-fast.c

unsigned char mhash[SHA256_DIGEST_LENGTH];

size_t length = 6; //bug?: 6== sizeof(data);

int main(void){
  unsigned char data[]="123456";

  fprintf(stdout,"Starting BruteForce ZeroHash search for %d bytes...\n", length);
  fflush(stdout);

  memset(mhash,0xff,SHA256_DIGEST_LENGTH*2);
  unsigned char l=0;
  do{
   unsigned char k=0;
   do{
    unsigned char j=0x5c;
    do{
     fprintf(stdout,"%-40s ______%02x%02x%02x\n", "", j, k,l);
     fflush(stdout);
     unsigned char i=0;
     do{
      data[2]=i;
      data[3]=j;
      data[4]=k;
      data[5]=l;
      fastIter(data);
      i++;
     }while(i!=0);
     j++;
    }while(j!=0);
    k++;
   }while(k!=0);
   l++;
  }while(l!=0);
  //printf("%ld",clock());
}

int fastIter(unsigned char data[]){
  unsigned char hash[SHA256_DIGEST_LENGTH];
  char buf[SHA_DIGEST_LENGTH*2];

  memset(buf, 0x0, SHA256_DIGEST_LENGTH*2);

  unsigned char k=0;
  do {
   data[0]=k;
   unsigned char l=0;
   do {
    data[1]=l;
    SHA256((const unsigned char *)data, length, hash);

    short j=0;
    do{
     if (hash[j]>mhash[j]) break;
     if (hash[j]<mhash[j]) {
      for (short c=0; c<SHA256_DIGEST_LENGTH; c++) {
       mhash[c]=hash[c];
      }
      for (int i=0; i < SHA256_DIGEST_LENGTH; i++) {
       sprintf((char*)&(buf[i*2]), "%02x", mhash[i]);
      }
      fprintf(stdout,"%s %02x%02x%02x%02x%02x%02x %ld\n", buf, k,l,data[2],data[3],data[4],data[5],clock());
      fflush(stdout);
      break;
     }
     j++;
    } while(j < SHA256_DIGEST_LENGTH);
    l++;
   } while(l!=0);
   k++;
  } while (k!=0);
}
