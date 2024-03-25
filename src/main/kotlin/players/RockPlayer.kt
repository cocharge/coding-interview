package players
import enums.Action

class RockPlayer : Player {
    override fun chooseAction(): Action {
        return Action.ROCK
    }
}