# LaravelBuilder

![Build](https://github.com/GooGee/LaravelBuilder/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/20064.svg)](https://plugins.jetbrains.com/plugin/20064)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/20064.svg)](https://plugins.jetbrains.com/plugin/20064)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [ ] Get familiar with the [template documentation][template].
- [ ] Verify the [pluginGroup](/gradle.properties), [plugin ID](/src/main/resources/META-INF/plugin.xml) and [sources package](/src/main/kotlin).
- [ ] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the Plugin ID in the above README badges.
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
# Laravel Builder

You no longer need to write migrations, Doctrine will do it for you.

[demo](https://googee.github.io/laravel-builder/build002)

## features

- design database schemas
- manage database migrations
- generate OpenApi document
- generate CRUD files

## install

```bash
composer require --dev googee/laravel-builder

php artisan vendor:publish --provider="GooGee\LaravelBuilder\LaravelBuilderServiceProvider"

php artisan setupLaravelBuilder
```

## Where is it?

PhpStorm Menu Bar -> Tools -> Laravel Builder

<!-- Plugin description end -->

## Installation

- Using IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "LaravelBuilder"</kbd> >
  <kbd>Install Plugin</kbd>
  
- Manually:

  Download the [latest release](https://github.com/GooGee/LaravelBuilder/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
