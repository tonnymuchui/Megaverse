package com.megaverse.model

import com.megaverse.common.Direction

data class Comeths(val direction: Direction, val row: Int, val column: Int) : AstralObject(row, column)
