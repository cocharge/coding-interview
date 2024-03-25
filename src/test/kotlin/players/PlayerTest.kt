package players

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import enums.Action

class PlayerTest {

    @Test
    fun `test RandomPlayer chooseAction`() {
        val randomPlayer = RandomPlayer()
        repeat(100) {
            val action = randomPlayer.chooseAction()
            assert(action == Action.ROCK || action == Action.PAPER || action == Action.SCISSORS)
        }
    }

    @Test
    fun `test RockPlayer chooseAction`() {
        val rockPlayer = RockPlayer()
        repeat(100) {
            val action = rockPlayer.chooseAction()
            assertEquals(Action.ROCK, action)
        }
    }

    @Test
    fun `test RandomPlayerFactory createPlayer`() {
        val playerFactory: PlayerFactory = RandomPlayerFactory()
        val player = playerFactory.createPlayer()
        assert(player is RandomPlayer)
    }

    @Test
    fun `test RockPlayerFactory createPlayer`() {
        val playerFactory: PlayerFactory = RockPlayerFactory()
        val player = playerFactory.createPlayer()
        assert(player is RockPlayer)
    }
}