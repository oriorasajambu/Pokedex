package com.example.dicoding.constant

import com.example.dicoding.R
import com.example.dicoding.constant.PokemonType.*
import com.example.dicoding.entity.Ability
import com.example.dicoding.entity.CatchRate
import com.example.dicoding.entity.Pokemon

object DataDummy {
    fun listDataDummy(): List<Pokemon> {
        return listOf(
            Pokemon(
                "001",
                R.drawable.bulbasaur,
                "Bulbasur",
                "Seed Pokémon",
                listOf(GRASS, POISON),
                "0,7 m (2′04″)",
                "6.9 kg (15.2 lbs)",
                listOf(
                    Ability("Overgrow", false),
                    Ability("Chlorophyll", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Bulbasaur is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Seed Pokémon.",
                true
            ),
            Pokemon(
                "002",
                R.drawable.ivysaur,
                "Ivysaur",
                "Seed Pokémon",
                listOf(GRASS, POISON),
                "1.0 m (3′03″)",
                "13.0 kg (28.7 lbs)",
                listOf(
                    Ability("Overgrow", false),
                    Ability("Chlorophyll", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Ivysaur is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Seed Pokémon.",
                false
            ),
            Pokemon(
                "003",
                R.drawable.venusaur,
                "Bulbasur",
                "Seed Pokémon",
                listOf(GRASS, POISON),
                "2.0 m (6′07″)",
                "100.0 kg (220.5 lbs)",
                listOf(
                    Ability("Overgrow", false),
                    Ability("Chlorophyll", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Venusaur is a Grass/Poison type Pokémon introduced in Generation 1. It is known as the Seed Pokémon.\nVenusaur has a Mega Evolution, available from X & Y onwards.",
                false
            ),
            Pokemon(
                "004",
                R.drawable.charmander,
                "Charmander",
                "Flame Pokémon",
                listOf(FIRE),
                "0.6 m (2′00″)",
                "8.5 kg (18.7 lbs)",
                listOf(
                    Ability("Blaze", false),
                    Ability("Solar Power", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Charmander is a Fire type Pokémon introduced in Generation 1. It is known as the Lizard Pokémon.",
                false
            ),
            Pokemon(
                "005",
                R.drawable.charmeleon,
                "Charmeleon",
                "Flame Pokémon",
                listOf(FIRE),
                "1.1 m (3′07″)",
                "19.0 kg (41.9 lbs)",
                listOf(
                    Ability("Blaze", false),
                    Ability("Solar Power", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Charmeleon is a Fire type Pokémon introduced in Generation 1. It is known as the Flame Pokémon.",
                false
            ),
            Pokemon(
                "006",
                R.drawable.charizard,
                "Charizard",
                "Flame Pokémon",
                listOf(FIRE, FLYING),
                "0,7 m (2'04\")",
                "6.9 kg (15.2 lbs)",
                listOf(
                    Ability("Blaze", false),
                    Ability("Solar Power", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Charizard is a Fire/Flying type Pokémon introduced in Generation 1. It is known as the Flame Pokémon. Charizard has two Mega Evolutions, available from X & Y onwards.",
                false
            ),
            Pokemon(
                "007",
                R.drawable.squirtle,
                "Squirtle",
                "Tiny Turtle Pokémon",
                listOf(WATER),
                "0.5 m (1′08″)",
                "9.0 kg (19.8 lbs)",
                listOf(
                    Ability("Torrent", false),
                    Ability("Rain Dish", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Squirtle is a Water type Pokémon introduced in Generation 1. It is known as the Tiny Turtle Pokémon.",
                false
            ),
            Pokemon(
                "008",
                R.drawable.wartortle,
                "Wartortle",
                "Tiny Turtle Pokémon",
                listOf(WATER),
                "1.0 m (3′03″)",
                "22.5 kg (49.6 lbs)",
                listOf(
                    Ability("Torrent", false),
                    Ability("Rain Dish", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Wartortle is a Water type Pokémon introduced in Generation 1. It is known as the Turtle Pokémon.",
                false
            ),
            Pokemon(
                "009",
                R.drawable.blastoise,
                "Blastoise",
                "Tiny Turtle Pokémon",
                listOf(WATER),
                "1.6 m (5′03″)",
                "85.5 kg (188.5 lbs)",
                listOf(
                    Ability("Torrent", false),
                    Ability("Rain Dish", true)
                ),
                CatchRate(
                    45, "5.9% with PokéBall, full HP"
                ),
                "Blastoise is a Water type Pokémon introduced in Generation 1. It is known as the Shellfish Pokémon. Blastoise has a Mega Evolution, available from X & Y onwards.",
                false
            ),
        )
    }
}