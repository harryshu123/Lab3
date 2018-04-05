package pkgCore;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPokerTest {

	@Test
	public void FourOfAKindTest1() {
		System.out.println("Four of a Kind: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE)); 
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isFourOfAKind(),true);

	}
	
	@Test
	public void FourOfAKindTest2() {
		System.out.println("Four of a Kind: Test 2");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.KING));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.KING));
		hp.AddCard(new Card(eSuit.SPADES,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING)); 
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isFourOfAKind(),true);

	}
	
	@Test
	public void ThreeOfAKindTest1() {
		System.out.println("Three of a Kind: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isThreeOfAKind(),true);

	}
	
	@Test
	public void ThreeOfAKindTest2() {
		System.out.println("Three of a Kind: Test 2");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.THREE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isThreeOfAKind(),true);

	}
	
	@Test
	public void TwoPairTest1() {
		System.out.println("Two Pair: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isTwoPair(),true);

	}
	
	@Test
	public void TwoPairTest2() {
		System.out.println("Two Pair: Test 2");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.ACE));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.THREE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		System.out.println("");
		
		assertEquals(hp.isTwoPair(),true);

	}
	
	@Test
	public void FullHouseTest1() {
		System.out.println("Full House: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FullHouseTest2() {
		System.out.println("Full House: Test 2");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.EIGHT));
		hp.ScoreHand();
		
		assertEquals(hp.isFullHouse(),true);
		
		System.out.println("");
	}
	
	@Test
	public void RoyalFlushTest1() {
		System.out.println("Royal Flush: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.ScoreHand();
		
		assertEquals(hp.isRoyalFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightFlushTest1() {
		System.out.println("Straight Flush: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraightFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void FlushTest1() {
		System.out.println("Flush: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.ACE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.ScoreHand();
		
		assertEquals(hp.isFlush(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest1() {
		System.out.println("Straight: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.FIVE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.SIX));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest2() {
		System.out.println("Straight: Test 2");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS,eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.TWO));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.FIVE));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");
	}
	
	@Test
	public void StraightTest3() {
		System.out.println("Straight: Test 3");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.HEARTS,eRank.ACE));
		hp.AddCard(new Card(eSuit.SPADES,eRank.KING));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.QUEEN));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.JACK));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TEN));
		hp.ScoreHand();
		
		assertEquals(hp.isStraight(),true);
		
		System.out.println("");
	}
	
	@Test
	public void HighCardTest1() {
		System.out.println("High Card: Test 1");
		HandPoker hp = new HandPoker();
		hp.AddCard(new Card(eSuit.CLUBS,eRank.TWO));
		hp.AddCard(new Card(eSuit.SPADES,eRank.EIGHT));
		hp.AddCard(new Card(eSuit.HEARTS,eRank.FOUR));
		hp.AddCard(new Card(eSuit.DIAMONDS,eRank.NINE));
		hp.AddCard(new Card(eSuit.CLUBS,eRank.THREE));
		hp.ScoreHand();
		
		assertEquals(hp.isHighCard(),true);
		
		System.out.println("");
	}

}
