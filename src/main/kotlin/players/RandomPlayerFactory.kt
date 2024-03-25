package players

class RandomPlayerFactory : PlayerFactory {
    override fun createPlayer(): Player {
        return RandomPlayer()
    }
}