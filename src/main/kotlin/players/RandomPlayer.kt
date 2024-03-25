package players
import kotlin.random.Random
import enums.Action

class RandomPlayer : Player {
    override fun chooseAction(): Action {
        return when (Random.nextInt(3)) {
            0 -> Action.ROCK
            1 -> Action.PAPER
            else -> Action.SCISSORS
        }
    }
}