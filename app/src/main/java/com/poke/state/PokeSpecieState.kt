package com.poke.state

data class PokeSpecieState(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    val baseHappiness: Int = 0,
    val captureRate: Int = 0,
    val genderRate: Int = 0,
    val hatchCounter: Int = 0,
    val order: Int = 0,
    val formsSwitchable: Boolean = false,
    val hasGenderDifferences: Boolean = false,
    val isBaby: Boolean = false,
    val isLegendary: Boolean = false,
    val isMythical: Boolean = false,
    val evolutionChain: EvolutionChain = EvolutionChain(),
    val evolvesFromSpecies: EvolvesFromSpecies = EvolvesFromSpecies(),
    val shape: Shape = Shape(),
    val generation: Generation = Generation(),
    val habitat: Habitat = Habitat(),
    val growthRate: GrowthRate = GrowthRate(),
    val color: Color = Color(),
    val names: List<Name> = listOf(),
    val eggGroups: List<EggGroup> = listOf(),
    val flavorTextEntries: List<FlavorTextEntry> = listOf(),
    val varieties: List<Variety> = listOf(),
    val palParkEncounters: List<PalParkEncounter> = listOf(),
    val pokeDexNumbers: List<PokeDexNumber> = listOf(),
    val genera: List<Genera> = listOf()
) {
    data class Color(
        val name: String = "",
        val url: String = ""
    )

    data class EggGroup(
        val name: String = "",
        val url: String = ""
    )

    data class EvolutionChain(
        val url: String = ""
    )

    data class EvolvesFromSpecies(
        val name: String = "",
        val url: String = ""
    )

    data class FlavorTextEntry(
        val flavorText: String = "",
        val language: Language = Language(),
        val version: Version = Version()
    ) {
        data class Language(
            val name: String = "",
            val url: String = ""
        )

        data class Version(
            val name: String = "",
            val url: String = ""
        )
    }

    data class Genera(
        val genus: String = "",
        val language: Language = Language()
    ) {
        data class Language(
            val name: String = "",
            val url: String = ""
        )
    }

    data class Generation(
        val name: String = "",
        val url: String = ""
    )

    data class GrowthRate(
        val name: String = "",
        val url: String = ""
    )

    data class Habitat(
        val name: String = "",
        val url: String = ""
    )

    data class Name(
        val name: String = "",
        val language: Language = Language()
    ) {
        data class Language(
            val name: String = "",
            val url: String = ""
        )
    }

    data class PalParkEncounter(
        val baseScore: Int = 0,
        val rate: Int = 0,
        val area: Area = Area()
    ) {
        data class Area(
            val name: String = "",
            val url: String = ""
        )
    }

    data class PokeDexNumber(
        val entryNumber: Int = 0,
        val pokeDex: PokeDex = PokeDex()
    ) {
        data class PokeDex(
            val name: String = "",
            val url: String = ""
        )
    }

    data class Shape(
        val name: String = "",
        val url: String = ""
    )

    data class Variety(
        val isDefault: Boolean = false,
        val pokemon: Pokemon = Pokemon()
    ) {
        data class Pokemon(
            val name: String = "",
            val url: String = ""
        )
    }
}
