/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.proyecto_rafael.data

import com.example.proyecto_rafael.data.Moviles

object Datasource {
    fun getMovilesList(): MutableList<Moviles> {
        val movilesList = mutableListOf<Moviles>(
            Moviles("Iphone 12",
            4,
            256,
            "iphone12"),

            Moviles("SamSung S24",
                12,
                256,
                "samsungs24"),
            Moviles("One Plus 6",
                12,
                512,
                "oneplus12"),
            Moviles("Xiaomi 14 Ultra",
                16,
                512,
                "xiaomi14ultra"),

            Moviles("Oppo a38",
                4,
                128,
                "oppoa38"),
            Moviles("Iphone 15 Pro",
                8,
                128,
                "iphone15pro"),
            Moviles("Iphone 11",
                4,
                128,
                "iphone11"),
            Moviles("Oppo Reno 10",
                8,
                256,
                "opporeno10"),
            Moviles("Motorola G73",
                8,
                256,
                "motorolag73"),
            Moviles("Iphone 13",
            6,
            128,
            "iphone13")
        )
        return movilesList
    }
}