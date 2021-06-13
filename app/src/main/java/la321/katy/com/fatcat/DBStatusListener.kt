package la321.katy.com.fatcat

fun interface DBStatusListener<T> {
    fun onSuccess(status: T?)
}