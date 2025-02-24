## Build tools & versions used

- agp: 8.9.0-alpha08
- kotlin: 2.0.21
- composeBom: 2025.02.00

## Steps to run the app

- Import app, sync gradle, run app with ctrl + R

## What areas of the app did you focus on?

- I focused on the architecture, creating one scalable, modularized by layers and clean code, its
  possible improve the architecture, creating a folder by features on future

## What was the reason for your focus? What problems were you trying to solve?

- I focused on architecture, to create a scalable project, with easy

## How long did you spend on this project?

- I spent 6 hours on this project

## Did you make any trade-offs for this project? What would you have done differently with more time?

- I didn't focus on the ui, I used the ready theme, given by android studio wizard theme, because on
  our daily, we have a design system to follow, but I used my time to teste the main parts of
  application (ViewModel, states, or classes with some logic)

## What do you think is the weakest part of your project?

- Maybe create more modules to contains the models, or create more components for text, and a design
  system more customized

## Is there any other information you’d like us to know?

- I created an architecture using data (retrofit, repository implementation), domain (repository,
  model classes), presentation(viewmodel, screens, state, ui, navigation), di (the creation of
  classes using koin), design module is the module that wrap the theme of application, and the
  module app contains the initial activity
- This architecture follow the domain centric model. Data and Presentation layers, knows domain
  layer, and domain layer doesn't have any dependency
- There are some tests (LightningCardTest, ExtensionsTests, NodesListViewModel, NodesListState)
- The LightningCardTest is using espresso and compose