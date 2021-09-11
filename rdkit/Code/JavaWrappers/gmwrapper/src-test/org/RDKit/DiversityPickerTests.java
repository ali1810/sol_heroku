/*
 *  Copyright (c) 2016, Greg Landrum
 *  All rights reserved.
 *
 *  This file is part of the RDKit.
 *  The contents are covered by the terms of the BSD license
 *  which is included in the file license.txt, found at the root
 *  of the RDKit source tree.
 *
 */
package org.RDKit;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.*;

public class DiversityPickerTests extends GraphMolTest {
	private EBV_Vect fps;

	@Before
	public void setUp() {
		String[] fpStrings = {"11110010101000000000",
		"00000000000010010000",
		"11001010000000000001",
		"00100110101000001000",
		"01010110000100011001",
		"11000110101001000011",
		"00000000001100001111",
		"00011110110000001101",
		"00000011011110100010",
		"11000010110001000000",
		"00000100010000010000",
		"10000001000010110010",
		"00010010000000010100",
		"00011100100110101000",
		"10001001100110100000",
		"10000110100110010000",
		"00101110000101000000",
		"11011101100011100000",
		"10000110000100101000",
		"00101000100000010001",
		"01000001000010000000",
		"00101101010100000110",
		"10001000100110110001",
		"00011000010100000001",
		"00101000001000100011",
		"00010000100010011001",
		"01100001000100010001",
		"10000101000001101101",
		"00001000011001011000",
		"11110000100100100000",
		"10100110000000011010",
		"00110100010110010010",
		"00000000000001010010",
		"00100000000010100001",
		"11110011000010001000",
		"10110001010100001000",
		"00001100100110011011",
		"00010010100100001110",
		"10100101100010100010",
		"01100100010100000001",
		"10101110011100000000",
		"01011000000001000001",
		"00000011100110100010",
		"01100001010001001001",
		"00001000000001001100",
		"10011001110000000100",
		"10110000001001100100",
		"00011000000001001011",
		"11001011010001100010",
		"10010000000001001011",
		"00010000100111100000",
		"00001000001110001000",
		"11010000010001100110",
		"01101001100000111000",
		"01001000001110111000",
		"10000000000100010010",
		"11001000010010000000",
		"01010010000100110001",
		"00010001010100100001",
		"01110010000000010000",
		"10001010000011000001",
		"00000110000000100100",
		"00010000010001000000",
		"11101100011010000011",
		"00000010100001010001",
		"00010000110010000101",
		"00010001001000111001",
		"01000010001100100110",
		"00110110000000100001",
		"00100010010110110010",
		"01000000110011001111",
		"00011000001000110010",
		"01111010101000110100",
		"00001010000010110110",
		"00110011000011011010",
		"00111010111010000110",
		"00010011101010000011",
		"00000001011000010000",
		"00011011101110110000",
		"00010001101000000001",
		"00010000001010011010",
		"00000010100100100010",
		"00000010001011000100",
		"11010000000001011100",
		"00001000110101000001",
		"00000010000000110010",
		"10000000010011000001",
		"11110110100100010000",
		"10001111000110001001",
		"00100110000110000100",
		"00000100100000100100",
		"00110000101100010100",
		"00001010100000100000",
		"01011000000011000111",
		"00010000100001010001",
		"10000010100000010000",
		"00001000000000110010",
		"00001000101011010001",
		"00011110000100100000",
		"11001001010001010100"};
		fps = new EBV_Vect();
		for(int i=0;i<fpStrings.length;i++){
			fps.add(new ExplicitBitVect(fpStrings[i].length()));
			RDKFuncs.FromBitString(fps.get(i),fpStrings[i]);
		}

	}

	@Test
	public void test1() {
		Int_Vect picks1 = RDKFuncs.pickUsingFingerprints(fps,5,42);
		assertEquals(picks1.size(),5);
		assertEquals(picks1.get(0),37);
		assertEquals(picks1.get(1),1);
		assertEquals(picks1.get(2),43);
		assertEquals(picks1.get(3),38);
		assertEquals(picks1.get(4),16);
	}
	@Test
	public void test2() {
		Int_Vect avoid = new Int_Vect();
		Int_Vect picks1 = RDKFuncs.pickUsingFingerprints(fps,5,0,avoid,false);
		Int_Vect picks2 = RDKFuncs.pickUsingFingerprints(fps,5,0,avoid,true);
		assertEquals(picks1.size(),5);
		assertEquals(picks2.size(),5);
		for(int i=0;i<picks1.size();++i)
			assertEquals(picks1.get(i),picks2.get(i));
	}
	@Test
	public void test3() {
		Int_Vect avoid = new Int_Vect();
		Int_Vect picks1 = RDKFuncs.pickUsingFingerprints(fps,5,-1);
		Int_Vect picks2 = RDKFuncs.pickUsingFingerprints(fps,5,-1);
		assertEquals(picks1.size(),5);
		assertEquals(picks2.size(),5);
		boolean allEqual=true;
		for(int i=0;i<picks1.size();++i){
			if(picks1.get(i)!=picks2.get(i)) allEqual=false;
		}
		assertFalse(allEqual);
	}

	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("org.RDKit.DiversityPickerTests");
	}

}
