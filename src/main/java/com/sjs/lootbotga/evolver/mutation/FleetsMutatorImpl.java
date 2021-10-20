package com.sjs.lootbotga.evolver.mutation;

import com.sjs.lootbotga.game.PirateFleetList;
import com.sjs.lootbotga.game.cards.*;
import com.sjs.lootbotga.game.player.Player;
import org.springframework.stereotype.Component;

import java.util.*;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

@Component
public class FleetsMutatorImpl implements FleetsMutator {
    @Override
    public PirateFleetList mutateFleets(PirateFleetList fleets) {

        PirateFleetList newFleetList = fleets;

        if (newFleetList.size() > 0) {
            int randomFleetValue = new Random().nextInt(newFleetList.size());

            int randomCardValue = new Random().nextInt(newFleetList.get(randomFleetValue).getHand().size());

            Card card = newFleetList.get(randomFleetValue).getHand().remove(randomCardValue);
            Card newCard = new PirateCardBuilder(card.getFleetType(), (PirateValue)getRandomCardValue(card.getValue())).build();


            newFleetList.get(randomFleetValue).getHand().add(randomCardValue, newCard);

        }

        return newFleetList;
    }

    private CardValue getRandomCardValue(CardValue value) {

        List<CardValue> cardValues = newArrayList(PirateValue.values())
                .stream()
                .filter(cardValue -> !cardValue.equals(value))
                .collect(toList());

        Collections.shuffle(cardValues);

        return cardValues.stream().findAny().get();
    }
}
