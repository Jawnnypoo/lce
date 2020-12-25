package com.laimiux.lce

fun <ContentT> LCE<Unit, ContentT, Throwable>.asUCT(): UCT<ContentT> {
    return when (val type = asLceType()) {
        is Type.Content -> type
        is Type.ThrowableError -> type
        is Type.UnitLoading -> type
        else -> throw IllegalStateException("this should not happen: $type")
    }
}

inline fun <ContentT> CE<ContentT, Throwable>.asUCT(): UCT<ContentT> {
    return when(val type = asLceType()) {
        is Type.Content -> type
        is Type.ThrowableError -> type
        else -> throw IllegalStateException("this should not happen: $type")
    }
}

inline fun <ContentT> CE<ContentT, Throwable>.asCT(): CT<ContentT> {
    return when(val type = asLceType()) {
        is Type.Content -> type
        is Type.ThrowableError -> type
        else -> throw IllegalStateException("this should not happen: $type")
    }
}