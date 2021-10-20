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
		Map<GameState, Move> motherStrategy = new HashMap<>();
		List<Card> hand1 = new ArrayList<>();
		hand1.add(new AdmiralCardBuilder().build());
		motherStrategy.put(new GameState(hand1, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.TWO).build(), MoveType.PLAY, null));
		List<Card> hand2 = new ArrayList<>();
		hand2.add(new MerchantCardBuilder(MerchantValue.TWO).build());
		motherStrategy.put(new GameState(hand2, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.FIVE).build(), MoveType.PLAY, null));
		List<Card> hand3 = new ArrayList<>();
		hand3.add(new CaptainCardBuilder(FleetType.BLUE).build());
		motherStrategy.put(new GameState(hand3, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.THREE).build(), MoveType.PLAY, null));
		List<Card> hand4 = new ArrayList<>();
		hand4.add(new MerchantCardBuilder(MerchantValue.THREE).build());
		motherStrategy.put(new GameState(hand4, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.FOUR).build(), MoveType.PLAY, null));
		List<Card> hand5 = new ArrayList<>();
		hand5.add(new MerchantCardBuilder(MerchantValue.FOUR).build());
		motherStrategy.put(new GameState(hand5, new ArrayList<>(), false), new Move(new PirateCardBuilder().fleet(FleetType.GREEN).value(PirateValue.TWO).build(), MoveType.PLAY, null));
		List<Card> hand6 = new ArrayList<>();
		hand6.add(new MerchantCardBuilder(MerchantValue.FIVE).build());
		motherStrategy.put(new GameState(hand6, new ArrayList<>(), false), new Move(new PirateCardBuilder().fleet(FleetType.BLUE).value(PirateValue.TWO).build(), MoveType.PLAY, new Battle()));
		List<Card> hand7 = new ArrayList<>();
		hand7.add(new MerchantCardBuilder(MerchantValue.SIX).build());
		motherStrategy.put(new GameState(hand7, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.SIX).build(), MoveType.PLAY, null));
		mother.setStrategy(motherStrategy);

		Player father = new PlayerImpl();
		Map<GameState, Move> fatherStrategy = new HashMap<>();
		List<Card> hand8 = new ArrayList<>();
		hand8.add(new AdmiralCardBuilder().build());
		fatherStrategy.put(new GameState(hand8, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.TWO).build(), MoveType.PLAY, null));
		List<Card> hand9 = new ArrayList<>();
		hand9.add(new CaptainCardBuilder(FleetType.GREEN).build());
		fatherStrategy.put(new GameState(hand9, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.THREE).build(), MoveType.PLAY, null));
		List<Card> hand10 = new ArrayList<>();
		hand10.add(new CaptainCardBuilder(FleetType.BLUE).build());
		fatherStrategy.put(new GameState(hand10, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.FOUR).build(), MoveType.PLAY, null));
		List<Card> hand11 = new ArrayList<>();
		hand11.add(new CaptainCardBuilder(FleetType.RED).build());
		fatherStrategy.put(new GameState(hand11, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.FIVE).build(), MoveType.PLAY, null));
		List<Card> hand12 = new ArrayList<>();
		hand12.add(new CaptainCardBuilder(FleetType.YELLOW).build());
		fatherStrategy.put(new GameState(hand12, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.SEVEN).build(), MoveType.PLAY, null));
		List<Card> hand13 = new ArrayList<>();
		hand13.add(new PirateCardBuilder().fleet(FleetType.GREEN).build());
		fatherStrategy.put(new GameState(hand13, new ArrayList<>(), false), new Move(new MerchantCardBuilder(MerchantValue.EIGHT).build(), MoveType.PLAY, null));
		List<Card> hand14 = new ArrayList<>();
		hand14.add(new PirateCardBuilder().fleet(FleetType.RED).build());
		fatherStrategy.put(new GameState(hand14, new ArrayList<>(), false), new Move(new CaptainCardBuilder(FleetType.BLUE).build(), MoveType.PLAY, null));
		List<Card> hand15 = new ArrayList<>();
		hand15.add(new PirateCardBuilder().fleet(FleetType.YELLOW).build());
		fatherStrategy.put(new GameState(hand15, new ArrayList<>(), false), new Move(new CaptainCardBuilder(FleetType.GREEN).build(), MoveType.PLAY, null));
		List<Card> hand16 = new ArrayList<>();
		hand16.add(new PirateCardBuilder().fleet(FleetType.BLUE).build());
		fatherStrategy.put(new GameState(hand16, new ArrayList<>(), false), new Move(new AdmiralCardBuilder().build(), MoveType.PLAY, null));
		List<Card> hand17 = new ArrayList<>();
		hand17.add(new MerchantCardBuilder(MerchantValue.TWO).build());
		fatherStrategy.put(new GameState(hand17, new ArrayList<>(), false), new Move(new PirateCardBuilder().fleet(FleetType.GREEN).value(PirateValue.FOUR).build(), MoveType.PLAY, null));
		List<Card> hand18 = new ArrayList<>();
		hand18.add(new MerchantCardBuilder(MerchantValue.THREE).build());
		fatherStrategy.put(new GameState(hand18, new ArrayList<>(), false), new Move(new PirateCardBuilder().fleet(FleetType.RED).value(PirateValue.THREE).build(), MoveType.PLAY, null));
		List<Card> hand19 = new ArrayList<>();
		hand19.add(new MerchantCardBuilder(MerchantValue.FOUR).build());
		fatherStrategy.put(new GameState(hand19, new ArrayList<>(), false), new Move(new PirateCardBuilder().fleet(FleetType.YELLOW).value(PirateValue.THREE).build(), MoveType.PLAY, null));
		father.setStrategy(fatherStrategy);

        when(randomProvider.random()).thenReturn(0.5);
		
		Player child = playerCrossover.breedPlayers(mother, father);

		assertThat(child).isNotNull();
		assertThat(child.getStrategy()).isNotNull();
        assertThat(mother.getStrategy()).isNotEqualTo(child.getStrategy());
        assertThat(father.getStrategy()).isNotEqualTo(child.getStrategy());
	}
}
