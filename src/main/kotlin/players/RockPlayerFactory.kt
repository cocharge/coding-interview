package players

class RockPlayerFactory : PlayerFactory {
    override fun createPlayer(): Player {
        return RockPlayer()
    }
}