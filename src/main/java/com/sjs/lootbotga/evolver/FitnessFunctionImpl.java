package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.PlayerResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FitnessFunctionImpl implements FitnessFunction {
    private static final double DEFAULT_LOWER_RANGE = 0.1;
    private static final double DEFAULT_UPPER_RANGE = 0.9;

    public List<PlayerProbability> evaluatePlayersChances(List<PlayerResult> playerResults) {

        return playerResults
                .stream()
                .map(this::generateProbability)
                .collect(Collectors.toList());
	}

    private PlayerProbability generateProbability(PlayerResult playerResult) {

        return new PlayerProbability(playerResult.getPlayer(),
                DEFAULT_LOWER_RANGE,
                DEFAULT_UPPER_RANGE);

    }
}
