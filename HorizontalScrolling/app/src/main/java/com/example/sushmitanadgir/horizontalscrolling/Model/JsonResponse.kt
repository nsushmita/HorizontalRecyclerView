package com.example.sushmitanadgir.horizontalscrolling.Model

data class JsonResponse(var page: Int,
                        var perPage: Int,
                        var total: Int,
                        var totalPages: Int,
                        var data: ArrayList<Datum>)


