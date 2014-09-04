package com.sjs.lootbotga.evolver;

import com.sjs.lootbotga.game.player.Player;
import com.sjs.lootbotga.game.player.PlayerImpl;
import com.sjs.lootbotga.game.player.PlayerResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class FitnessFunctionImplTest {

    @InjectMocks
    private FitnessFunctionImpl fitnessFunction;

    @Test
	public void shouldApplyDefaultRangesIfNoWins() {
        Player player = new PlayerImpl();
        List<PlayerResult> playerResults = new ArrayList<>();
        playerResults.add(new PlayerResult(player, 0));

        List<PlayerProbability> playerProbabilityList = fitnessFunction.evaluatePlayersChances(playerResults);

        assertThat(playerProbabilityList).hasSameSizeAs(playerResults);
	}
}