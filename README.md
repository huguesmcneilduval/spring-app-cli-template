# Spring App with CLI

> Simple project template to have a spring app wrapped with a CLI and build as a native image.
> 
> The CLI is built using picocli

## Table of Contents
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Contributing](#contributing)
- [License](#license)

## Installation

Install the maven dependencies with
```bash
mvn install
```
## Usage

To start the application, use:
```bash
cli-project
```

Make sure that `${user.home}/.local/bin` is on your path


## Features

- cli-project --help
- cli-project start
- cli-project status
- cli-project restart
- cli-project stop

## Contributing

Contributions are welcome! Please follow these steps:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. Commit your changes:
   ```bash
   git commit -m "Add your message here"
   ```
4. Push to the branch:
   ```bash
   git push origin feature/your-feature-name
   ```
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
