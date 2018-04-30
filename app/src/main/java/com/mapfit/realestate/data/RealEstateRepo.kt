package com.mapfit.realestate.data

import com.mapfit.realestate.model.RealEstate

class RealEstateRepo {

    fun getRealEstates(): List<List<RealEstate>> {

        val allRealEstates = mutableListOf<List<RealEstate>>()
        allRealEstates.apply {
            add(littleItaly())
            add(eastVillage())
            add(murrayHill())
            add(stuyesantTown())
            add(washingtonHeights())
            add(centralHarlem())
            add(soho())
            add(spanishHarlem())
            add(financialDistrict())
            add(tribeca())
            add(morningsideHeights())
            add(hellsKitchen())
            add(flatironDistrict())
            add(midtownWest())
            add(midtownEast())
            add(greenwichVillage())
            add(batteryParkCity())
            add(chinaTown())
            add(lowerEastSide())
            add(gramercy())
            add(upperWestSide())
            add(westVillage())
            add(inwood())
            add(hamiltonHeights())
            add(noho())
            add(twoBridges())
            add(nolita())
            add(kipsBay())
            add(upperEastSide())
            add(chelsea())
            add(cityHallArea())
            add(rooseveltIsland())
        }

        return allRealEstates
    }

    private fun financialDistrict(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "65 Broadway, New York, NY 10006",
                "Financial District, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "124 Fulton St, New York, NY 10038",
                "Financial District, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "48 Wall St, New York, NY 10005",
                "Financial District, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt4",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "16 Beaver St, New York, NY 10004",
                "Financial District, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun greenwichVillage(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "23 E 9th St, New York, NY 10003",
                "Greenwich Village, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt4",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "566 LaGuardia Pl, New York, NY 10012",
                "Greenwich Village, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun batteryParkCity(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "98 Battery Pl, New York, NY 10280",
                "Battery Park City, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "380 Rector Pl, New York, NY 10280",
                "Battery Park City, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt4",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "211 North End Ave, New York, NY 10282",
                "Battery Park City, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun littleItaly(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "199 Hester St, New York, NY 10013",
                "Little Italy, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "197 Grand St, New York, NY 10013",
                "Little Italy, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "225 Canal St, New York, NY 10013",
                "Little Italy, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun chelsea(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "312 W 23rd St, New York, NY 10011",
                "Chelsea, Manhattan",
                1,
                1,
                700,
                "June 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "626 W 28th St, New York, NY 10001",
                "Chelsea, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,000",
                "170 8th Ave, New York, NY 10011",
                "Chelsea, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun eastVillage(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "222A E 11th St New York, NY 10003",
                "East Village, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "309 E 5th St, New York, NY 10003",
                "East Village, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$2,200",
                "709 E 6th St, New York, NY 10009",
                "East Village, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun tribeca(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "60 Vestry St, New York, NY 10013",
                "Tribeca, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "110 Chambers St, New York, NY 10007",
                "Tribeca, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "65 Worth St, New York, NY 10013",
                "Tribeca, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun chinaTown(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "110 Centre St, New York, NY 10013",
                "Chinatown, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "25 Allen St, New York, NY 10002",
                "Chinatown, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun murrayHill(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "593 3rd Ave, New York, NY 10016",
                "Murray Hill, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "248 E 35th St, New York, NY 10016",
                "Murray Hill, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "139 E 36th St, New York, NY 10016",
                "Murray Hill, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun stuyesantTown(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "510 E 20th St, New York, NY 10009",
                "Stuyvesant Town, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "451 E 14th St, New York, NY 10009",
                "Stuyvesant Town, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "285 Avenue C Loop New York, NY 10009",
                "Stuyvesant Town, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun washingtonHeights(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "720 W 173rd St,New York, NY 10032",
                "Washington Heights, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "521 W 157th St, New York, NY 10032",
                "Washington Heights, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$2,300",
                "643 W 172nd St, New York, NY 10032",
                "Washington Heights, Manhattan",
                2,
                1,
                700,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$2,300",
                "120 Cabrini Blvd, New York, NY 10033",
                "Washington Heights, Manhattan",
                2,
                1,
                910,
                "June 19th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$2,300",
                "615 W 184th St, New York, NY 10033",
                "Washington Heights, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun centralHarlem(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "2538 Adam Clayton Powell Jr Blvd, New York, NY 10039",
                "Central Harlem, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "300 W 135th St, New York, NY 10027",
                "Central Harlem, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "8 Mt Morris Park W, New York, NY 10027",
                "Central Harlem, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun soho(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "34 Macdougal St, New York, NY 10012",
                "SoHo, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "55 Vandam St, New York, NY 10013",
                "SoHo, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "463 Broome St, New York, NY 10013",
                "SoHo, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun spanishHarlem(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "102 E 125th St, New York, NY 10035",
                "Spanish Harlem, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "315 103rd St, New York, NY 10029",
                "Spanish Harlem, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$2,300",
                "168 E 104th St, New York, NY 10029",
                "Spanish Harlem, Manhattan",
                2,
                1,
                910,
                "June 19th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$2,800",
                "351 E 119th St, New York, NY 10035",
                "Spanish Harlem, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun morningsideHeights(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "3133 Broadway, New York, NY 10027",
                "Morningside Heights, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "536 W 113th St, New York, NY 10025",
                "Morningside Heights, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "380 Riverside Dr, New York, NY 10025",
                "Morningside Heights, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun hellsKitchen(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "519 W 36th St, New York, NY 10018",
                "Hell's Kitchen, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "365 W 36th St, New York, NY 10018",
                "Hell's Kitchen, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "353 W 39th St, New York, NY 10018",
                "Hell's Kitchen, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun flatironDistrict(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "44 W 24th St, New York, NY 10010",
                "Flatiron District, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "21 E 22nd St, New York, NY 10010",
                "Flatiron District, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "48 W 21st St, New York, NY 10010",
                "Flatiron District, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun midtownWest(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "532 W 43rd St, New York, NY 10036",
                "Midtown West, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "428 W 44th St, New York, NY 10036",
                "Midtown West, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "353 W 48th St, New York, NY 10036",
                "Midtown West, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,200",
                "1023 6th Ave, New York, NY 10018",
                "Midtown West, Manhattan",
                3,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,500",
                "145 W 46th St, New York, NY 10036",
                "Midtown West, Manhattan",
                3,
                2,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,100",
                "145 W 46th St, New York, NY 10036",
                "Midtown West, Manhattan",
                3,
                2,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,600",
                "39 W 56th St, New York, NY 10019",
                "Midtown West, Manhattan",
                1,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun midtownEast(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "253 E 50th St, New York, NY 10022",
                "Midtown East, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "120 E 47th St, New York, NY 10017",
                "Midtown East, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "111 E 56th St, New York, NY 10022",
                "Midtown East, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun lowerEastSide(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "74-100 Ridge St, New York, NY 10002",
                "Lower East Side, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "67-1 Norfolk St, New York, NY 10002",
                "Lower East Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "350 Grand St, New York, NY 10002",
                "Lower East Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt4",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "219-229 Clinton St, New York, NY 10002",
                "Lower East Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun gramercy(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "179 3rd Ave, New York, NY 10003",
                "Gramercy, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "152 E 21st St, New York, NY 10010",
                "Gramercy, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun upperWestSide(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "215 W 106th St, New York, NY 10025",
                "Upper West Side, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "328 W 86th St, New York, NY 10024",
                "Upper West Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "835 Columbus Ave, New York, NY 10025",
                "Upper West Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,200",
                "59 W 88th St, New York, NY 10024",
                "Upper West Side, Manhattan",
                3,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,500",
                "261 W 70th St, New York, NY 10023",
                "Upper West Side, Manhattan",
                3,
                2,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,100",
                "216 W 62nd St, New York, NY 10023",
                "Upper West Side, Manhattan",
                3,
                2,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,600",
                "433 W 66th St, New York, NY 10069",
                "Upper West Side, Manhattan",
                1,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun westVillage(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "173 Christopher St, New York, NY 10014",
                "West Village, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "55 Bethune St, New York, NY 10014",
                "West Village, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "220 W 13th St, New York, NY 10011",
                "West Village, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun inwood(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "639 W 204th St, New York, NY 10034",
                "Inwood, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "112 Sherman Ave, New York, NY 10034",
                "Inwood, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "585 W 214th St, New York, NY 10034",
                "Inwood, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )
    }

    private fun hamiltonHeights(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "610 W 145th St, New York, NY 10031",
                "Hamilton Heights, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "501 W 138th St, New York, NY 10031",
                "Hamilton Heights, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "618 W 143rd St, New York, NY 10031",
                "Hamilton Heights, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun noho(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "430 Lafayette St, New York, NY 10003",
                "NoHo, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "9 Great Jones St, New York, NY 10003",
                "NoHo, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "7 Bleecker St, New York, NY 10012",
                "NoHo, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun twoBridges(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "34 Monroe St, New York, NY 10002",
                "Two Bridges, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "51 Monroe St, New York, NY 10002",
                "Two Bridges, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "89 Catherine St, New York, NY 10038",
                "Two Bridges, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun nolita(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "31 Prince St, New York, NY 10012",
                "Nolita, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "85 Kenmare St, New York, NY 10012",
                "Nolita, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "6 Spring St, New York, NY 10012",
                "Nolita, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )


    }

    private fun kipsBay(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "229 E 29th St, New York, NY 10016",
                "Kips Bay, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "238 E 24th St, New York, NY 10010",
                "Kips Bay, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "522 1st Avenue, New York, NY 10016",
                "Kips Bay, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun upperEastSide(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "179 E 94th St, New York, NY 10128",
                "Upper East Side, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "47 E 90th St, New York, NY 10128",
                "Upper East Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "121 E 81st St, New York, NY 10028",
                "Upper East Side, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,200",
                "307 E 87th St, New York, NY 10128",
                "Upper East Side, Manhattan",
                3,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,500",
                "9 E 77th St, New York, NY 10075",
                "Upper East Side, Manhattan",
                3,
                2,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$4,100",
                "405 E 72nd St, New York, NY 10021",
                "Upper East Side, Manhattan",
                3,
                2,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt3",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,600",
                "167 E 64th St, New York, NY 10065",
                "Upper East Side, Manhattan",
                1,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun cityHallArea(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "49 Chambers St, New York, NY 10007",
                "City Hall Area, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "141 Worth St, New York, NY 10013",
                "City Hall Area, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

    private fun rooseveltIsland(): List<RealEstate> {
        return listOf(
            RealEstate(
                "apt1",
                "https://images.unsplash.com/photo-1505873242700-f289a29e1e0f?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=91b874ce453385d8867cc98ee582fee3&auto=format&fit=crop&w=1024&q=80",
                "$2,400",
                "625 Main St, New York, NY 10044",
                "Roosevelt Island, Manhattan",
                2,
                1,
                350,
                "July 14th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$3,200",
                "501 Main St, New York, NY 10044",
                "Roosevelt Island, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            ),
            RealEstate(
                "apt2",
                "https://images.unsplash.com/photo-1494526585095-c41746248156?ixlib=rb-0.3.5&ixid=eyJhcHBfaWQiOjEyMDd9&s=fd170b4cebb0b97e6337529754defcf7&auto=format&fit=crop&w=1024&q=80",
                "$5,300",
                "30 River Rd, New York, NY 10044",
                "Roosevelt Island, Manhattan",
                2,
                1,
                900,
                "June 16th, 2018"
            )
        )

    }

}