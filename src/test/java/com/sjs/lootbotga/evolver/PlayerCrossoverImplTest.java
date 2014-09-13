package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.Battle;
import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.*;
import com.sjs.lootbotga.provider.RandomProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerCrossoverImplTest {

    @Mock
    private RandomProvider randomProvider;

    @InjectMocks
    private PlayerCrossoverImpl playerCrossover;

    @Test
	public void testBreedPlayers() {
		Player mother =new PlayerImpl();
		Map<GameState, Move> motherStrategy = new HashMap<GameState, Move>();
		List<Card> hand1 = new ArrayList<Card>();
		hand1.add(new AdmiralCardBuilder().build());
		motherStrategy.put(new GameState(hand1, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.TWO).build(), MoveType.PLAY, null));
		List<Card> hand2 = new ArrayList<Card>();
		hand2.add(new MerchantCardBuilder().value(MerchantValue.TWO).build());
		motherStrategy.put(new GameState(hand2, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.FIVE).build(), MoveType.PLAY, null));
		List<Card> hand3 = new ArrayList<Card>();
		hand3.add(new CaptainCardBuilder().build());
		motherStrategy.put(new GameState(hand3, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.THREE).build(), MoveType.PLAY, null));
		List<Card> hand4 = new ArrayList<Card>();
		hand4.add(new MerchantCardBuilder().value(MerchantValue.THREE).build());
		motherStrategy.put(new GameState(hand4, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.FOUR).build(), MoveType.PLAY, null));
		List<Card> hand5 = new ArrayList<Card>();
		hand5.add(new MerchantCardBuilder().value(MerchantValue.FOUR).build());
		motherStrategy.put(new GameState(hand5, new ArrayList<Battle>(), false), new Move(new PirateCardBuilder().fleet(FleetType.GREEN).value(PirateValue.TWO).build(), MoveType.PLAY, null));
		List<Card> hand6 = new ArrayList<Card>();
		hand6.add(new MerchantCardBuilder().value(MerchantValue.FIVE).build());
		motherStrategy.put(new GameState(hand6, new ArrayList<Battle>(), false), new Move(new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.TWO).build(), MoveType.PLAY, new Battle()));
		List<Card> hand7 = new ArrayList<Card>();
		hand7.add(new MerchantCardBuilder().value(MerchantValue.SIX).build());
		motherStrategy.put(new GameState(hand7, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.SIX).build(), MoveType.PLAY, null));
		mother.setStrategy(motherStrategy);

		Player father = new PlayerImpl();
		Map<GameState, Move> fatherStrategy = new HashMap<GameState, Move>();
		List<Card> hand8 = new ArrayList<Card>();
		hand8.add(new AdmiralCardBuilder().build());
		fatherStrategy.put(new GameState(hand8, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.TWO).build(), MoveType.PLAY, null));
		List<Card> hand9 = new ArrayList<Card>();
		hand9.add(new CaptainCardBuilder().fleet(FleetType.GREEN).build());
		fatherStrategy.put(new GameState(hand9, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.THREE).build(), MoveType.PLAY, null));
		List<Card> hand10 = new ArrayList<Card>();
		hand10.add(new CaptainCardBuilder().fleet(FleetType.BLUE).build());
		fatherStrategy.put(new GameState(hand10, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.FOUR).build(), MoveType.PLAY, null));
		List<Card> hand11 = new ArrayList<Card>();
		hand11.add(new CaptainCardBuilder().fleet(FleetType.PURPLE).build());
		fatherStrategy.put(new GameState(hand11, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.FIVE).build(), MoveType.PLAY, null));
		List<Card> hand12 = new ArrayList<Card>();
		hand12.add(new CaptainCardBuilder().fleet(FleetType.YELLOW).build());
		fatherStrategy.put(new GameState(hand12, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.SEVEN).build(), MoveType.PLAY, null));
		List<Card> hand13 = new ArrayList<Card>();
		hand13.add(new PirateCardBuilder().fleet(FleetType.GREEN).build());
		fatherStrategy.put(new GameState(hand13, new ArrayList<Battle>(), false), new Move(new MerchantCardBuilder().value(MerchantValue.EIGHT).build(), MoveType.PLAY, null));
		List<Card> hand14 = new ArrayList<Card>();
		hand14.add(new PirateCardBuilder().fleet(FleetType.PURPLE).build());
		fatherStrategy.put(new GameState(hand14, new ArrayList<Battle>(), false), new Move(new CaptainCardBuilder().fleet(FleetType.BLUE).build(), MoveType.PLAY, null));
		List<Card> hand15 = new ArrayList<Card>();
		hand15.add(new PirateCardBuilder().fleet(FleetType.YELLOW).build());
		fatherStrategy.put(new GameState(hand15, new ArrayList<Battle>(), false), new Move(new CaptainCardBuilder().fleet(FleetType.GREEN).build(), MoveType.PLAY, null));
		List<Card> hand16 = new ArrayList<Card>();
		hand16.add(new PirateCardBuilder().fleet(FleetType.BLUE).build());
		fatherStrategy.put(new GameState(hand16, new ArrayList<Battle>(), false), new Move(new AdmiralCardBuilder().build(), MoveType.PLAY, null));
		List<Card> hand17 = new ArrayList<Card>();
		hand17.add(new MerchantCardBuilder().value(MerchantValue.TWO).build());
		fatherStrategy.put(new GameState(hand17, new ArrayList<Battle>(), false), new Move(new PirateCardBuilder().fleet(FleetType.GREEN).value(PirateValue.FOUR).build(), MoveType.PLAY, null));
		List<Card> hand18 = new ArrayList<Card>();
		hand18.add(new MerchantCardBuilder().value(MerchantValue.THREE).build());
		fatherStrategy.put(new GameState(hand18, new ArrayList<Battle>(), false), new Move(new PirateCardBuilder().fleet(FleetType.PURPLE).value(PirateValue.THREE).build(), MoveType.PLAY, null));
		List<Card> hand19 = new ArrayList<Card>();
		hand19.add(new MerchantCardBuilder().value(MerchantValue.FOUR).build());
		fatherStrategy.put(new GameState(hand19, new ArrayList<Battle>(), false), new Move(new PirateCardBuilder().fleet(FleetType.YELLOW).value(PirateValue.THREE).build(), MoveType.PLAY, null));
		father.setStrategy(fatherStrategy);

        when(randomProvider.random()).thenReturn(0.5);
		
		Player child = playerCrossover.breedPlayers(mother, father);

		assertThat(child).isNotNull();
		assertThat(child.getStrategy()).isNotNull();
        assertThat(mother.getStrategy()).isNotEqualTo(child.getStrategy());
        assertThat(father.getStrategy()).isNotEqualTo(child.getStrategy());
	}
}
