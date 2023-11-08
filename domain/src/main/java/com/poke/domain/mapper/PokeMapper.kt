package com.poke.domain.mapper

import com.poke.data.response.PokeResponse
import com.poke.data.response.PokeSpecieResponse
import com.poke.domain.entity.Poke
import com.poke.domain.entity.PokeSpecie

fun PokeResponse.toModel() = Poke(
    count = count,
    next = next,
    results = results.map {
        Poke.Result(
            id = getUrl(it.url),
            name = it.name,
            url = it.url
        )
    }
)

private fun getUrl(url: String): Int {
    val result = url.split("/")
    return result[result.size - 2].toInt()
}

fun PokeSpecieResponse.toModel() = PokeSpecie(
    id = id!!,
    name = name!!,
    baseHappiness = base_happiness!!,
    captureRate = capture_rate!!,
    genderRate = gender_rate!!,
    hatchCounter = hatch_counter!!,
    order = order!!,
    hasGenderDifferences = has_gender_differences,

    formsSwitchable = forms_switchable,

   isBaby = is_baby,
   isLegendary = is_legendary,
   isMythical = is_mythical,
   evolutionChain = PokeSpecie.EvolutionChain(
       url = "evolution_chain.url"
   ),
   evolvesFromSpecies = PokeSpecie.EvolvesFromSpecies(
       name = "evolves_from_species.name",
       url = "evolves_from_species.url"
   ),
   shape = PokeSpecie.Shape(
       name = "shape.name",
       url = "shape.url"
   ),
   generation = PokeSpecie.Generation(
       name = "generation.name",
       url = "generation.url",
   ),
   habitat = PokeSpecie.Habitat(
       name = "habitat.name",
       url = "habitat.url",
   ),
   growthRate = PokeSpecie.GrowthRate(
       name = "growth_rate.name",
       url = "growth_rate.url",
   ),
   color = PokeSpecie.Color(
       name = "color.name",
       url = "color.url"
   ),
  names = names.map {
       PokeSpecie.Name(
           name = it.name,
           language = PokeSpecie.Name.Language(
               name = it.language.name,
               url = it.language.url
           )
       )
   },

   eggGroups = egg_groups.map {
       PokeSpecie.EggGroup(
           name = it.name,
           url = it.url
       )
   },
   flavorTextEntries = flavor_text_entries.map {
       PokeSpecie.FlavorTextEntry(
           flavorText = it.flavor_text,
           language = PokeSpecie.FlavorTextEntry.Language(
               name = it.language.name,
               url = it.language.url,
           ),
           version = PokeSpecie.FlavorTextEntry.Version(
               name = it.version.name,
               url = it.version.url,
           ),
       )
   },
   varieties = varieties.map {
       PokeSpecie.Variety(
           isDefault = it.is_default,
           pokemon = PokeSpecie.Variety.Pokemon(
               name = it.pokemon.name,
               url = it.pokemon.url
           )
       )
   },
   palParkEncounters = pal_park_encounters.map {
       PokeSpecie.PalParkEncounter(
           baseScore = it.base_score,
           rate = it.rate,
           area = PokeSpecie.PalParkEncounter.Area(
               name = it.area.name,
               url = it.area.url
           )
       )
   },
   pokeDexNumbers = pokedex_numbers.map {
       PokeSpecie.PokeDexNumber(
           entryNumber = it.entry_number,
           pokeDex = PokeSpecie.PokeDexNumber.PokeDex(
               name = it.pokedex.name,
               url = it.pokedex.url
           )
       )
   },

   genera = genera.map {
       PokeSpecie.Genera(
           genus = it.genus,
           language = PokeSpecie.Genera.Language(
               name = it.language.name,
               url = it.language.url,
           )
       )
   }
)
