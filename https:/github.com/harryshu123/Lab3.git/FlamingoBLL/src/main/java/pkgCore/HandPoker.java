package pkgCore;

import java.util.ArrayList;
import java.util.Collections;
import pkgConstants.*;
import pkgEnum.eCardNo;
import pkgEnum.eHandStrength;
import pkgEnum.eRank;
import pkgEnum.eSuit;

public class HandPoker extends Hand {

	private ArrayList<CardRankCount> CRC = null;

	public HandPoker() {
		this.setHS(new HandScorePoker());
	}

	protected ArrayList<CardRankCount> getCRC() {
		return CRC;
	}

	@Override
	public HandScore ScoreHand() {

		Collections.sort(super.getCards());
		Frequency();

		if (isRoyalFlush()) {
			System.out.println("Royal Flush: PASS");
		} else if (isStraightFlush()) {
			System.out.println("Straight Flush: PASS");
		}else if (isFourOfAKind()) {
			System.out.println("Four of a Kind: PASS");
		}else if (isFullHouse()) {
			System.out.println("Full House: PASS");
		}else if (isFlush()) {
			System.out.println("Flush: PASS");
		}else if (isStraight()) {
			System.out.println("Straight: PASS");
		}else if (isThreeOfAKind()) {
			System.out.println("Three of a Kind: PASS");
		}else if (isTwoPair()) {
			System.out.println("Two Pair: PASS");
		}else if (isPair()) {
			System.out.println("Pair: Pass");
		}else if (isHighCard()) {
			System.out.println("High Card: Pass");
		}

		return null;
	}

	public boolean isRoyalFlush() {
		boolean bIsRoyalFlush = false;
		
		if(isStraightFlush() && (super.getCards().get(0).geteRank() == eRank.ACE && super.getCards().get(4).geteRank() == eRank.TEN)) {
			bIsRoyalFlush = true;
			
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.RoyalFlush);
			int iGetCard = this.getCRC().get(0).getiCardPosition();
			HSP.setHiCard(this.getCards().get(iGetCard));
			
		}
		return bIsRoyalFlush;
	}

	public boolean isStraightFlush() {
		boolean bisStraightFlush = false;

		if(isFlush() && isStraight()) {
			bisStraightFlush = true;
			
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.StraightFlush);
			int iGetCard = this.getCRC().get(0).getiCardPosition();
			HSP.setHiCard(this.getCards().get(iGetCard));
		}
		return bisStraightFlush;
	}
	
	public boolean isFourOfAKind() {
		boolean bisFourOfAKind = false;

		if (this.getCRC().get(0).getiCnt() == Constants.FOUR_OF_A_KIND) {

				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.FourOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
				
				bisFourOfAKind = true;
		}
	
		return bisFourOfAKind;
	}

	public boolean isFullHouse() {
		boolean bisFullHouse = false;
		if(isThreeOfAKind() && isPair()) {

			bisFullHouse = true;
			
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.FullHouse);
			int iGetCard = this.getCRC().get(0).getiCardPosition();
			HSP.setHiCard(this.getCards().get(iGetCard));
		}
		
		return bisFullHouse;

	}

	public boolean isFlush() {
		boolean bisFlush = false;

		int iCardCnt = super.getCards().size();
		int iSuitCnt = 0;

		for (eSuit eSuit : eSuit.values()) {
			for (Card c : super.getCards()) {
				if (eSuit == c.geteSuit()) {
					iSuitCnt++;
				}
			}
			if (iSuitCnt > 0)
				break;
		}

		if (iSuitCnt == iCardCnt) {
			bisFlush = true;		
			
			HandScorePoker HSP = (HandScorePoker) this.getHS();
			HSP.seteHandStrength(eHandStrength.Flush);
			int iGetCard = this.getCRC().get(0).getiCardPosition();
			HSP.setHiCard(this.getCards().get(iGetCard));
		}
		else
			bisFlush = false;

		return bisFlush;
	}

	public boolean isStraight() {
		boolean bisStraight = true;
		// TODO : Implement this method
		int a = 0;
		if(super.getCards().get(0).geteRank() == eRank.ACE) {
			a = 1;			
		}
		for(; a < super.getCards().size()-1;a++) {
			if(super.getCards().get(a).geteRank().getiRankNbr()-1 != super.getCards().get(a+1).geteRank().getiRankNbr()) {
				bisStraight = false;
			}
		}
		
	//	if((super.getCards().get(1).geteRank() != eRank.FIVE) && (super.getCards().get(0).geteRank() == eRank.ACE)) {
	//		a = 1;
	//	}
		
		
		return bisStraight;
	}

	public boolean isThreeOfAKind() {
		boolean bisThreeOfAKind = false;

		if (this.getCRC().get(0).getiCnt() == Constants.THREE_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.ThreeOfAKind);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
				bisThreeOfAKind = true;
			
		}
		
		
		return bisThreeOfAKind;
	}

	public boolean isTwoPair() {
		boolean bisTwoPair = false;
		
		int tally = 0;
		
		for (int a = 0; a < this.getCRC().size(); a++) {
			
			if (this.getCRC().get(a).getiCnt() == Constants.TWO_OF_A_KIND) {
				tally++;
			}
		}
		
		if (tally == 2) {
						
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.Pair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
				
				bisTwoPair = true;
				
		}
				
		return bisTwoPair;
	}

	public boolean isPair() {
		boolean bisPair = false;
		
		for (int a = 0; a < this.getCRC().size(); a++) {
			
			if (this.getCRC().get(a).getiCnt() == Constants.TWO_OF_A_KIND) {
				HandScorePoker HSP = (HandScorePoker) this.getHS();
				HSP.seteHandStrength(eHandStrength.Pair);
				int iGetCard = this.getCRC().get(0).getiCardPosition();
				HSP.setHiCard(this.getCards().get(iGetCard));
				HSP.setLoCard(null);
				HSP.setKickers(FindTheKickers(this.getCRC()));
				this.setHS(HSP);
				
				bisPair = true;
			}
		}
		return bisPair;
	}

	public boolean isHighCard() {
		boolean bisHighCard = true;
		
		HandScorePoker HSP = (HandScorePoker) this.getHS();
		HSP.seteHandStrength(eHandStrength.HighCard);
		int iGetCard = this.getCRC().get(0).getiCardPosition();
		HSP.setHiCard(this.getCards().get(iGetCard));
		
		return bisHighCard;
	}

	private ArrayList<Card> FindTheKickers(ArrayList<CardRankCount> CRC) {
		ArrayList<Card> kickers = new ArrayList<Card>();

		for (CardRankCount crcCheck : CRC) {
			if (crcCheck.getiCnt() == 1) {
				kickers.add(this.getCards().get(crcCheck.getiCardPosition()));
			}
		}

		return kickers;
	}

	private void Frequency() {
		CRC = new ArrayList<CardRankCount>();
		int iCnt = 0;
		int iPos = 0;
		for (eRank eRank : eRank.values()) {
			iCnt = (CountRank(eRank));
			if (iCnt > 0) {
				iPos = FindCardRank(eRank);
				CRC.add(new CardRankCount(eRank, iCnt, iPos));
			}
		}
		Collections.sort(CRC);
	}

	private int CountRank(eRank eRank) {
		int iCnt = 0;
		for (Card c : super.getCards()) {
			if (c.geteRank() == eRank) {
				iCnt++;
			}
		}
		return iCnt;
	}

	private int FindCardRank(eRank eRank) {
		int iPos = 0;

		for (iPos = 0; iPos < super.getCards().size(); iPos++) {
			if (super.getCards().get(iPos).geteRank() == eRank) {
				break;
			}
		}
		return iPos;
	}

}
