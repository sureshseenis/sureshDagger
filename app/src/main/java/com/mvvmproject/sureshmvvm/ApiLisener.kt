package cchcc.learn.amu

interface ApiLisener {
    fun onSuccess(successData: Any)
    fun onFailure(error: Throwable)
}