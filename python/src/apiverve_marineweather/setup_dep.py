from setuptools import setup, find_packages

setup(
    name='apiverve_marineweather',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Marine Weather fetches offshore weather conditions for any marine coordinates by latitude and longitude. Each response details high and low temperatures, maximum wind speeds, precipitation totals, humidity, UV index, and sunrise and sunset times.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/marineweather?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
