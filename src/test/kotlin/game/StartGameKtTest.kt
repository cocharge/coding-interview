package game


import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import enums.Action
import enums.Result
import players.RandomPlayerFactory
import players.RockPlayerFactory

class StartGameKtTest {


    @Test
    fun `test evaluateResult`() {
        assertEquals(Result.DRAW, evaluateResult(Action.ROCK, Action.ROCK))
        assertEquals(Result.DRAW, evaluateResult(Action.PAPER, Action.PAPER))
        assertEquals(Result.DRAW, evaluateResult(Action.SCISSORS, Action.SCISSORS))

        assertEquals(Result.WIN, evaluateResult(Action.ROCK, Action.SCISSORS))
        assertEquals(Result.WIN, evaluateResult(Action.PAPER, Action.ROCK))
        assertEquals(Result.WIN, evaluateResult(Action.SCISSORS, Action.PAPER))

        assertEquals(Result.LOSE, evaluateResult(Action.SCISSORS, Action.ROCK))
        assertEquals(Result.LOSE, evaluateResult(Action.ROCK, Action.PAPER))
        assertEquals(Result.LOSE, evaluateResult(Action.PAPER, Action.SCISSORS))
    }

    @Test
    fun `test game`() {
        val playerAFactory = RandomPlayerFactory()
        val playerBFactory = RockPlayerFactory()

        val playerA = playerAFactory.createPlayer()
        val playerB = playerBFactory.createPlayer()

        val totalRounds = 100
        var playerARoundsWon = 0
        var playerBRoundsWon = 0
        var draws = 0

        repeat(totalRounds) {
            val playerAAction = playerA.chooseAction()
            val playerBAction = playerB.chooseAction()

            when (evaluateResult(playerAAction, playerBAction)) {
                Result.WIN -> playerARoundsWon++
                Result.LOSE -> playerBRoundsWon++
                Result.DRAW -> draws++
            }
        }

        val totalGames = playerARoundsWon + playerBRoundsWon + draws
        assertEquals(totalRounds, totalGames)

        println("Player A wins $playerARoundsWon of $totalRounds games")
        println("Player B wins $playerBRoundsWon of $totalRounds games")
        println("Draws: $draws of $totalRounds games")
    }
}