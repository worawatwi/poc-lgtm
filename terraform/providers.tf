// TERRAMATE: GENERATED AUTOMATICALLY DO NOT EDIT

terraform {
  required_version = "1.5.7"
}
terraform {
  required_providers {
    google = {
      source  = "hashicorp/google"
      version = ">= 5.6, < 6"
    }
    google-beta = {
      source  = "hashicorp/google-beta"
      version = ">= 5.6, < 6"
    }
    random = {
      source  = "hashicorp/random"
      version = "~> 3.5"
    }
  }
}
provider "google" {
  billing_project       = "tdnest-ops"
  project               = "tdnest-ops"
  region                = "asia-southeast1"
  user_project_override = true
}
provider "google-beta" {
  billing_project       = "tdnest-ops"
  project               = "tdnest-ops"
  region                = "asia-southeast1"
  user_project_override = true
}
