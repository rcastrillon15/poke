package com.poke.data.response

data class PokeSpecieResponse(
    val id: Int?,
    val name: String?,
    val base_happiness: Int?,
    val capture_rate: Int?,
    val gender_rate: Int?,
    val hatch_counter: Int?,
    val order: Int?,
    val forms_switchable: Boolean,
    val has_gender_differences: Boolean,
    val is_baby: Boolean,
    val is_legendary: Boolean,
    val is_mythical: Boolean,
    val evolution_chain: EvolutionChain,
    val evolves_from_species: EvolvesFromSpecies,
    val shape: Shape,
    val generation: Generation,
    val habitat: Habitat,
    val growth_rate: GrowthRate,
    val color: Color,
    val egg_groups: List<EggGroup>,
    val genera: List<Genera>,
    val flavor_text_entries: List<FlavorTextEntry>,
    val names: List<Name>,
    val pokedex_numbers: List<PokedexNumber>,
    val pal_park_encounters: List<PalParkEncounter>,
    val varieties: List<Variety>
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
        val flavor_text: String,
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
        val language: Language,
        val name: String
    ) {
        data class Language(
            val name: String,
            val url: String
        )
    }

    data class PalParkEncounter(
        val area: Area,
        val base_score: Int,
        val rate: Int
    ) {
        data class Area(
            val name: String,
            val url: String
        )
    }

    data class PokedexNumber(
        val entry_number: Int,
        val pokedex: Pokedex
    ) {
        data class Pokedex(
            val name: String,
            val url: String
        )
    }

    data class Shape(
        val name: String,
        val url: String
    )

    data class Variety(
        val is_default: Boolean,
        val pokemon: Pokemon
    ) {
        data class Pokemon(
            val name: String,
            val url: String
        )
    }
}
