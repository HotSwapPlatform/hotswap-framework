# hotswap-framework

Reusable Java library implementing the ports and adapters (hexagonal architecture) pattern with runtime-swappable adapters.

## What it provides

Three port interfaces and one ready-made selector implementation:

| Class | Description |
|-------|-------------|
| `AdapterControlPort<T>` | Base interface for controlling adapters |
| `SingletonAdapterSelectorPort<T>` | Selects exactly one active adapter at a time |
| `MultiAdapterSelectorPort<T>` | Allows multiple adapters to be active simultaneously |
| `SingletonSelectorAdapter<T>` | Ready-made implementation of `SingletonAdapterSelectorPort` |

## Usage

Add to your Maven project:

```xml
<dependency>
    <groupId>io.github.ilkka-n</groupId>
    <artifactId>hotswap-framework</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

## Build

```bash
./mvnw test
```

## Part of HotSwapPlatform

- [hotswap-finance-ai](https://github.com/HotSwapPlatform/hotswap-finance-ai) — Finance AI demo using this framework
- [hotswap-postgis-railways](https://github.com/HotSwapPlatform/hotswap-postgis-railways) — PostGIS railways demo
- [hotswap-platform-ui](https://github.com/HotSwapPlatform/hotswap-platform-ui) — React control panel
