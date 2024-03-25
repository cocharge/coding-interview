package players

import enums.Action

interface Player {
    fun chooseAction(): Action
}