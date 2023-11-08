package com.poke.domain.entity

data class PokeSpecie(
    val id: Int,
    val name: String,
    val baseHappiness: Int,
    val captureRate: Int,
    val genderRate: Int,
    val hatchCounter: Int,
    val order: Int,
    val formsSwitchable: Boolean,
    val hasGenderDifferences: Boolean,
    val isBaby: Boolean,
    val isLegendary: Boolean,
    val isMythical: Boolean,
    val evolutionChain: EvolutionChain,
    val evolvesFromSpecies: EvolvesFromSpecies,
    val shape: Shape,
    val generation: Generation,
    val habitat: Habitat,
    val growthRate: GrowthRate,
    val color: Color,
    val names: List<Name>? = listOf(),
    val eggGroups: List<EggGroup>? = listOf(),
    val flavorTextEntries: List<FlavorTextEntry>? = listOf(),
    val varieties: List<Variety>? = listOf(),
    val palParkEncounters: List<PalParkEncounter>? = listOf(),
    val pokeDexNumbers: List<PokeDexNumber>? = listOf(),
    val genera: List<Genera>? = listOf()
) {
    data class Color(
        val name: String,
        val url: String
    )

    data class EggGroup(
        val name: String,
        val url: String
    )

    data class EvolutionChain(
        val url: String
    )

    data class EvolvesFromSpecies(
        val name: String,
        val url: String
    )

    data class FlavorTextEntry(
        val flavorText: String,
        val language: Language,
        val version: Version
    ) {
        data class Language(
            val name: String,
            val url: String
        )

        data class Version(
            val name: String,
            val url: String
        )
    }

    data class Genera(
        val genus: String,
        val language: Language
    ) {
        data class Language(
            val name: String,
            val url: String
        )
    }

    data class Generation(
        val name: String,
        val url: String
    )

    data class GrowthRate(
        val name: String,
        val url: String
    )

    data class Habitat(
        val name: String,
        val url: String
    )

    data class Name(
        val name: String,
        val language: Language
    ) {
        data class Language(
            val name: String,
            val url: String
        )
    }

    data class PalParkEncounter(
        val baseScore: Int,
        val rate: Int,
        val area: Area
    ) {
        data class Area(
            val name: String,
            val url: String
        )
    }

    data class PokeDexNumber(
        val entryNumber: Int,
        val pokeDex: PokeDex
    ) {
        data class PokeDex(
            val name: String,
            val url: String
        )
    }

    data class Shape(
        val name: String,
        val url: String
    )

    data class Variety(
        val isDefault: Boolean,
        val pokemon: Pokemon
    ) {
        data class Pokemon(
            val name: String,
            val url: String
        )
    }
}
