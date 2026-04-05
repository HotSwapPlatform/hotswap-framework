# HotSwapPlatform — yhteiset koodauskäytännöt

Tämä tiedosto koskee kaikkia HotSwapPlatform-projekteja:
- hotswap-framework
- hotswap-finance-ai
- hotswap-postgis-railways
- hotswap-platform-ui

---

## Työskentelyperiaatteet

1. **TDD** — testit ensin, sitten toteutus
2. **Pienet muutokset** — yksi asia kerrallaan
3. **Jatkuva varmistus** — kaikki ehdotetut muutokset tarkistetaan ennen hyväksyntää
4. **Ei pyytämättömiä muutoksia** — älä ujuta ylimääräisiä muutoksia mukaan
5. Aja testit jokaisen muutoksen jälkeen ja raportoi tulos
6. Jos testi hajoaa, korjaa se ennen kuin jatkat
7. **try-finally feikki-ajastimien purussa** — muista tämä kaikkialla

---

## Commit-käytäntö

Conventional Commits: `feat:`, `fix:`, `docs:`, `refactor:`, `test:`, `chore:`, `ci:`

Commit-viestit suomeksi.

---

## Git-konfiguraatio

Per-repo (ei globaali):
- `user.email` = `266712533+ilkka-n@users.noreply.github.com`
- `user.name` = `ilkka-n`

---

# hotswap-framework — projektikonteksti

## Tarkoitus

Uudelleenkäytettävä Java-kirjasto portti- ja adapteriarkkitehtuuriin (heksagonaalinen arkkitehtuuri). Tarjoaa geneerisen mekanismin adapterien ajonaikaiseen vaihtoon.

---

## Tekninen stack

- Java 21, Spring Boot (vain spring-boot-starter-test testeihin)
- Maven (itsenäinen pom.xml, spring-boot-starter-parent suoraan)
- JUnit 5 + Mockito

---

## Rakenne

```
src/main/java/io/github/ilkka_n/hotswap/
├── core/ports/
│   ├── AdapterControlPort<T>            — perusrajapinta adapterin hallintaan
│   ├── SingletonAdapterSelectorPort<T>  — yksi aktiivinen adapteri kerrallaan
│   └── MultiAdapterSelectorPort<T>      — useita aktiivisia samanaikaisesti
└── adapters/
    └── SingletonSelectorAdapter<T>      — valmis toteutus SingletonAdapterSelectorPort:lle
```

## Porttihierarkia

```
AdapterControlPort<T>
├── SingletonAdapterSelectorPort<T>
└── MultiAdapterSelectorPort<T>
```

---

## Testien tila

- 6 testiä, kaikki vihreitä
- JaCoCo koodikattavuus käytössä

---

## Tärkeää

- Core on puhdas Java — ei framework-annotaatioita
- Kirjasto julkaistaan `mvn install`:lla paikalliseen Maven-cacheen
- Muut repot (hotswap-finance-ai) riippuvat tästä — muutokset voivat rikkoa ne
- Älä lisää riippuvuuksia ilman hyväksyntää
