{{- define "garmin-scaler.name" -}}
garmin-scaler
{{- end }}

{{- define "garmin-scaler.fullname" -}}
{{- printf "%s" (include "garmin-scaler.name" .) -}}
{{- end }}
