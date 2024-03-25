package game

import enums.Action
import enums.Result
import players.RandomPlayerFactory
import players.RockPlayerFactory


fun main(args: Array<String>) {
    val totalRounds = 100
    var playerARoundsWon = 0
    var playerBRoundsWon = 0
    var draws = 0

    val playerAFactory = RandomPlayerFactory()
    val playerBFactory = RockPlayerFactory()

    val playerA = playerAFactory.createPlayer()
    val playerB = playerBFactory.createPlayer()

    repeat(totalRounds) {
        val playerAAction = playerA.chooseAction()
        val playerBAction = playerB.chooseAction()

        when (evaluateResult(playerAAction, playerBAction)) {
            enums.Result.WIN -> playerARoundsWon++
            enums.Result.LOSE -> playerBRoundsWon++
            enums.Result.DRAW -> draws++
        }
    }

    println("Player A wins $playerARoundsWon of $totalRounds games")
    println("Player B wins $playerBRoundsWon of $totalRounds games")
    println("Draws: $draws of $totalRounds games")
}
    fun evaluateResult(actionA: Action, actionB: Action): Result {
        return when {
            actionA == actionB -> Result.DRAW
            (actionA == Action.ROCK && actionB == Action.SCISSORS) ||
                    (actionA == Action.PAPER && actionB == Action.ROCK) ||
                    (actionA == Action.SCISSORS && actionB == Action.PAPER) -> Result.WIN
            else -> Result.LOSE
        }
    }
