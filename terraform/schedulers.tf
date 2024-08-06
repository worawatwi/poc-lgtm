// TERRAMATE: GENERATED AUTOMATICALLY DO NOT EDIT

module "start_stop_scheduler" {
  source = "github.com/oun/gcp-instances-scheduler.git//terraform?ref=v0.10.0"

  project_id = "tdnest-ops"
  region     = "asia-southeast1"
  start_topic = "start-instance"
  stop_topic  = "stop-instance"
  time_zone   = "Asia/Bangkok"

  schedules = [
    {
      project = "tdnest-ops"
      resource_types = [
        "gke",
      ]
      start_job_name = "start-gke-nodepool"
      start_schedule = "30 8 * * 1-5"
      stop_job_name  = "stop-gke-nodepool"
      stop_schedule  = "0 19 * * 1-5"
    },
  ]

  gke_function_config = {
    enabled            = true
    max_instance_count = 1
  }
}
