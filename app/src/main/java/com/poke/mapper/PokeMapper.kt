package com.poke.mapper

import com.poke.common.Constants
import com.poke.domain.entity.Poke
import com.poke.domain.entity.PokeSpecie
import com.poke.state.PokeSpecieState
import com.poke.state.PokeState

fun Poke.toState() = PokeState(
    count = count,
    next = next,
    results = results.map {
        PokeState.Result(
            id = it.id,
            name = it.name,
            url = "${Constants.URL_IMAGE}${it.id}.png"
        )
    }
)

fun PokeSpecie.toState() = PokeSpecieState(
    id = id,
    name = name,
    url = "${Constants.URL_IMAGE}${id}.png",
    baseHappiness = baseHappiness,
    captureRate = captureRate,
    genderRate = genderRate,
    hatchCounter = hatchCounter,
    order = order,
    hasGenderDifferences = hasGenderDifferences,
    formsSwitchable = formsSwitchable,
    isBaby = isBaby,
    isLegendary = isLegendary,
    isMythical = isMythical,
    evolutionChain = PokeSpecieState.EvolutionChain(
        url = evolutionChain.url
    ),
    evolvesFromSpecies = PokeSpecieState.EvolvesFromSpecies(
        name = evolvesFromSpecies.name,
        url = evolvesFromSpecies.url
    ),
    shape = PokeSpecieState.Shape(
        name = shape.name,
        url = shape.url
    ),
    generation = PokeSpecieState.Generation(
        name = generation.name,
        url = generation.url,
    ),
    habitat = PokeSpecieState.Habitat(
        name = habitat.name,
        url = habitat.url,
    ),
    growthRate = PokeSpecieState.GrowthRate(
        name = growthRate.name,
        url = growthRate.url,
    ),
    color = PokeSpecieState.Color(
        name = color.name,
        url = color.url
    ),
    names = names!!.map { //TODO: Change this !!
        PokeSpecieState.Name(
            name = it.name,
            language = PokeSpecieState.Name.Language(
                name = it.language.name,
                url = it.language.url
            )
        )
    },

    eggGroups = eggGroups!!.map {
        PokeSpecieState.EggGroup(
            name = it.name,
            url = it.url
        )
    },
    flavorTextEntries = flavorTextEntries!!.map {
        PokeSpecieState.FlavorTextEntry(
            flavorText = it.flavorText,
            language = PokeSpecieState.FlavorTextEntry.Language(
                name = it.language.name,
                url = it.language.url,
            ),
            version = PokeSpecieState.FlavorTextEntry.Version(
                name = it.version.name,
                url = it.version.url,
            ),
        )
    },
    varieties = varieties!!.map {
        PokeSpecieState.Variety(
            isDefault = it.isDefault,
            pokemon = PokeSpecieState.Variety.Pokemon(
                name = it.pokemon.name,
                url = it.pokemon.url
            )
        )
    },
    palParkEncounters = palParkEncounters!!.map {
        PokeSpecieState.PalParkEncounter(
            baseScore = it.baseScore,
            rate = it.rate,
            area = PokeSpecieState.PalParkEncounter.Area(
                name = it.area.name,
                url = it.area.url
            )
        )
    },
    pokeDexNumbers = pokeDexNumbers!!.map {
        PokeSpecieState.PokeDexNumber(
            entryNumber = it.entryNumber,
            pokeDex = PokeSpecieState.PokeDexNumber.PokeDex(
                name = it.pokeDex.name,
                url = it.pokeDex.url
            )
        )
    },

    genera = genera!!.map {
        PokeSpecieState.Genera(
            genus = it.genus,
            language = PokeSpecieState.Genera.Language(
                name = it.language.name,
                url = it.language.url,
            )
        )
    }
)
