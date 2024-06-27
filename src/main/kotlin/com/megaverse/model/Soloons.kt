package com.megaverse.model

import com.megaverse.common.Color

data class Soloons(val color: Color, val row: Int, val column: Int) : AstralObject(row, column)
