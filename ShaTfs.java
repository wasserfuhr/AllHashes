//https://github.com/sci4me/SKristMiner/blob/master/src/main/java/com/sci/skristminer/util/SHA256.java
//package com.sci.skristminer.util;@author sci4me
import java.io.*;
public final class ShaTfs{
    //https://www.nayuki.io/res/notepadcrypt-format-decryptor-java/decryptnotepadcrypt.java
    private static byte[] getSha256Hash(byte[] msg) {
	if (msg.length > Integer.MAX_VALUE / 8)
	    throw new IllegalArgumentException("Message too large for this implementation");
	
	// Add 1 byte for termination, 8 bytes for length, then round up to multiple of block size (64)
	byte[] padded = Arrays.copyOf(msg, (msg.length + 1 + 8 + 63) / 64 * 64);
	padded[msg.length] = (byte)0x80;
	for (int i = 0; i < 4; i++)
	    padded[padded.length - 1 - i] = (byte)((msg.length * 8) >>> (i * 8));
	
	// Table of round constants
	final int[] K = {
	    0x428A2F98, 0x71374491, 0xB5C0FBCF, 0xE9B5DBA5, 0x3956C25B, 0x59F111F1, 0x923F82A4, 0xAB1C5ED5,
	    0xD807AA98, 0x12835B01, 0x243185BE, 0x550C7DC3, 0x72BE5D74, 0x80DEB1FE, 0x9BDC06A7, 0xC19BF174,
	    0xE49B69C1, 0xEFBE4786, 0x0FC19DC6, 0x240CA1CC, 0x2DE92C6F, 0x4A7484AA, 0x5CB0A9DC, 0x76F988DA,
	    0x983E5152, 0xA831C66D, 0xB00327C8, 0xBF597FC7, 0xC6E00BF3, 0xD5A79147, 0x06CA6351, 0x14292967,
	    0x27B70A85, 0x2E1B2138, 0x4D2C6DFC, 0x53380D13, 0x650A7354, 0x766A0ABB, 0x81C2C92E, 0x92722C85,
	    0xA2BFE8A1, 0xA81A664B, 0xC24B8B70, 0xC76C51A3, 0xD192E819, 0xD6990624, 0xF40E3585, 0x106AA070,
	    0x19A4C116, 0x1E376C08, 0x2748774C, 0x34B0BCB5, 0x391C0CB3, 0x4ED8AA4A, 0x5B9CCA4F, 0x682E6FF3,
	    0x748F82EE, 0x78A5636F, 0x84C87814, 0x8CC70208, 0x90BEFFFA, 0xA4506CEB, 0xBEF9A3F7, 0xC67178F2,
	};
	
	// Compress each block
	int[] state = {0x6A09E667, 0xBB67AE85, 0x3C6EF372, 0xA54FF53A, 0x510E527F, 0x9B05688C, 0x1F83D9AB, 0x5BE0CD19};
	for (int off = 0; off < padded.length; off += 64) {
	    int[] schedule = new int[64];
	    for (int i = 0; i < 16; i++)
		schedule[i] = toInt32(padded, off + i * 4);
	    for (int i = 16; i < 64; i++) {
		int x = schedule[i - 15];
		int y = schedule[i -  2];
		schedule[i] = schedule[i - 16] + schedule[i - 7] +
		    (rotateRight(x,  7) ^ rotateRight(x, 18) ^ (x >>>  3)) +
		    (rotateRight(y, 17) ^ rotateRight(y, 19) ^ (y >>> 10));
	    }
	    
	    int a = state[0], b = state[1], c = state[2], d = state[3];
	    int e = state[4], f = state[5], g = state[6], h = state[7];
	    for (int i = 0; i < 64; i++) {
		int t1 = h + (rotateRight(e, 6) ^ rotateRight(e, 11) ^ rotateRight(e, 25)) + ((e & f) ^ (~e & g)) + K[i] + schedule[i];
		int t2 = (rotateRight(a, 2) ^ rotateRight(a, 13) ^ rotateRight(a, 22)) + ((a & b) ^ (a & c) ^ (b & c));
		h = g;
		g = f;
		f = e;
		e = d + t1;
		d = c;
		c = b;
		b = a;
		a = t1 + t2;
	    }
	    state[0] += a; state[1] += b; state[2] += c; state[3] += d;
	    state[4] += e; state[5] += f; state[6] += g; state[7] += h;
	}
	
	// Serialize state as result
	byte[] hash = new byte[state.length * 4];
	for (int i = 0; i < hash.length; i++)
	    hash[i] = (byte)(state[i / 4] >>> ((3 - i % 4) * 8));
	return hash;
    }
 private static final int[] K = {
  0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1, 0x923f82a4, 0xab1c5ed5,
  0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3, 0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174,
  0xe49b69c1, 0xefbe4786, 0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
  0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147, 0x06ca6351, 0x14292967,
  0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13, 0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85,
  0xa2bfe8a1, 0xa81a664b, 0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
  0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a, 0x5b9cca4f, 0x682e6ff3,
  0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208, 0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2};
 private ShaTfs(){}
 public static void main(String[]a) throws Exception{
  InputStreamReader i=new InputStreamReader(System.in);
  ByteArrayOutputStream buf = new ByteArrayOutputStream();
  int r;
  while((r=i.read())>=0){
   buf.write(r);}
  byte d[]=//digest(
		  getSha256Hash(buf.toByteArray());
  StringBuilder sb = new StringBuilder(32);
  for(byte b:d)sb.append(String.format("%02x",b&0xff));
  System.out.println(sb.toString());
 }

 public static byte[] digest(final byte[] message){
  byte[] hashed = new byte[32], padded = padMessage(message);
  int h0=0x6a09e667;
  int h1=0xbb67ae85;
  int h2=0x3c6ef372;
  int h3=0xa54ff53a;
  int h4=0x510e527f;
  int h5=0x9b05688c;
  int h6=0x1f83d9ab;
  int h7=0x5be0cd19;
  final int pl64=padded.length/64;
  int i,j,sa,sb,j4;
  int a,b,c,d,e,f,g,h,s0,s1,maj,t1,t2,ch,i64;
  int[] words=new int[64];
  for(i=0;i<pl64;i++){
            a = h0;
            b = h1;
            c = h2;
            d = h3;
            e = h4;
            f = h5;
            g = h6;
            h = h7;
            i64 = i * 64;

            for (j = 0; j < 16; j++)
            {
                j4 = j * 4 + i64;
                words[j] |= ((padded[j4] & 0x000000FF) << 24);
                words[j] |= ((padded[j4 + 1] & 0x000000FF) << 16);
                words[j] |= ((padded[j4 + 2] & 0x000000FF) << 8);
                words[j] |= (padded[j4 + 3] & 0x000000FF);
            }

            for (j = 16; j < 64; j++)
            {
                sa = words[j - 15];
                sb = words[j - 2];
                s0 = Integer.rotateRight(sa, 7) ^ Integer.rotateRight(sa, 18) ^ (sa >>> 3);
                s1 = Integer.rotateRight(sb, 17) ^ Integer.rotateRight(sb, 19) ^ (sb >>> 10);
                words[j] = words[j - 16] + s0 + words[j - 7] + s1;
            }

            for (j = 0; j < 64; j++)
            {
                s0 = Integer.rotateRight(a, 2) ^ Integer.rotateRight(a, 13) ^ Integer.rotateRight(a, 22);
                maj = (a & b) ^ (a & c) ^ (b & c);
                t2 = s0 + maj;
                s1 = Integer.rotateRight(e, 6) ^ Integer.rotateRight(e, 11) ^ Integer.rotateRight(e, 25);
                ch = (e & f) ^ (~e & g);
                t1 = h + s1 + ch + ShaTfs.K[j] + words[j];

                h = g;
                g = f;
                f = e;
                e = d + t1;
                d = c;
                c = b;
                b = a;
                a = t1 + t2;
            }

            h0 += a;
            h1 += b;
            h2 += c;
            h3 += d;
            h4 += e;
            h5 += f;
            h6 += g;
            h7 += h;
        }

        hashed[0] = (byte) ((h0 >>> 56) & 0xff);
        hashed[1] = (byte) ((h0 >>> 48) & 0xff);
        hashed[2] = (byte) ((h0 >>> 40) & 0xff);
        hashed[3] = (byte) ((h0 >>> 32) & 0xff);

        hashed[4] = (byte) ((h1 >>> 56) & 0xff);
        hashed[5] = (byte) ((h1 >>> 48) & 0xff);
        hashed[6] = (byte) ((h1 >>> 40) & 0xff);
        hashed[7] = (byte) ((h1 >>> 32) & 0xff);

        hashed[8] = (byte) ((h2 >>> 56) & 0xff);
        hashed[9] = (byte) ((h2 >>> 48) & 0xff);
        hashed[10] = (byte) ((h2 >>> 40) & 0xff);
        hashed[11] = (byte) ((h2 >>> 32) & 0xff);

        hashed[12] = (byte) ((h3 >>> 56) & 0xff);
        hashed[13] = (byte) ((h3 >>> 48) & 0xff);
        hashed[14] = (byte) ((h3 >>> 40) & 0xff);
        hashed[15] = (byte) ((h3 >>> 32) & 0xff);

        hashed[16] = (byte) ((h4 >>> 56) & 0xff);
        hashed[17] = (byte) ((h4 >>> 48) & 0xff);
        hashed[18] = (byte) ((h4 >>> 40) & 0xff);
        hashed[19] = (byte) ((h4 >>> 32) & 0xff);

        hashed[20] = (byte) ((h5 >>> 56) & 0xff);
        hashed[21] = (byte) ((h5 >>> 48) & 0xff);
        hashed[22] = (byte) ((h5 >>> 40) & 0xff);
        hashed[23] = (byte) ((h5 >>> 32) & 0xff);

        hashed[24] = (byte) ((h6 >>> 56) & 0xff);
        hashed[25] = (byte) ((h6 >>> 48) & 0xff);
        hashed[26] = (byte) ((h6 >>> 40) & 0xff);
        hashed[27] = (byte) ((h6 >>> 32) & 0xff);

        hashed[28] = (byte) ((h7 >>> 56) & 0xff);
        hashed[29] = (byte) ((h7 >>> 48) & 0xff);
        hashed[30] = (byte) ((h7 >>> 40) & 0xff);
        hashed[31] = (byte) ((h7 >>> 32) & 0xff);

        return hashed;
    }

    private static byte[] padMessage(final byte[] data)
    {
        final int origLength = data.length;
        final int tailLength = origLength % 64;

        final int padLength;
        if ((64 - tailLength >= 9))
            padLength = 64 - tailLength;
        else
            padLength = 128 - tailLength;

        final byte[] output = new byte[origLength + padLength];

        final long lengthInBits = origLength * 8;
        final int lm1 = output.length - 1;
        output[lm1] = (byte) (lengthInBits & 0xFF);
        output[lm1 - 1] = (byte) ((lengthInBits >>> 8) & 0xFF);
        output[lm1 - 2] = (byte) ((lengthInBits >>> 16) & 0xFF);
        output[lm1 - 3] = (byte) ((lengthInBits >>> 24) & 0xFF);
        output[lm1 - 4] = (byte) ((lengthInBits >>> 32) & 0xFF);
        output[lm1 - 5] = (byte) ((lengthInBits >>> 40) & 0xFF);
        output[lm1 - 6] = (byte) ((lengthInBits >>> 48) & 0xFF);
        output[lm1 - 7] = (byte) ((lengthInBits >>> 56) & 0xFF);
        output[origLength] = (byte) 0x80;

        System.arraycopy(data, 0, output, 0, origLength);

        return output;
    }
}